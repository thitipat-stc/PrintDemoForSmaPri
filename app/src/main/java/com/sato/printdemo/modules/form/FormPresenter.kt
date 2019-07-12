package com.sato.printdemo.modules.form

import android.util.Base64
import android.util.Log
import com.sato.printdemo.dao.smapri.DAOLocalNull
import com.sato.printdemo.dao.smapri.DAOLocalRaw
import com.sato.printdemo.services.HttpManager
import com.sato.printdemo.util.Utils
import retrofit2.Response

class FormPresenter(views: FormConstructor.FormSetView) : FormConstructor.FormSetPresenter {

    private val view = views
    private val variableMap: HashMap<String, String> = HashMap()

    override fun getInfo() {
        HttpManager.getInstance().getApiService().getDataLocalHostNull()
            .enqueue(object : retrofit2.Callback<DAOLocalNull> {
                override fun onFailure(call: retrofit2.Call<DAOLocalNull>, t: Throwable) {
                    Log.e(Utils.LOG_TAG, "Failure: $t")
                }

                override fun onResponse(call: retrofit2.Call<DAOLocalNull>, response: Response<DAOLocalNull>) {
                    if (response.isSuccessful) {
                        Log.i(Utils.LOG_TAG, "Response success:  ${response.message()}")
                        getInfoResponse(response.body())
                    } else {
                        Log.w(Utils.LOG_TAG, "Response not success: ${response.message()}")
                    }
                }
            })
    }

    private fun getInfoResponse(body: DAOLocalNull?) {
        Log.d(
            Utils.LOG_TAG, "Response: " +
                    "[.@productVersion] ${body?.productVersion}\n" +
                    "[message] ${body?.message}\n" +
                    "[result] ${body?.result}\n" +
                    "[function] ${body?.function}\n" +
                    "[.deviceType] ${body?.deviceType}\n" +
                    "[.@creationTime] ${body?.creationTime}\n" +
                    "[.@productName] ${body?.productName}"
        )
        view.getInfoSuccess(body)
        view.showSnackBar("Connect Success")
    }

    override fun printItem(_id: String, _name: String, _price: String) {
        if (_price.toInt() <= 20000) {
            val standard = checkPrice(_id, _name, _price, Utils.LABEL_STANDARD)
            sentStandardRawData(standard)
        }
        if (_price.toInt() > 20000) {
            val premium = checkPrice(_id, _name, _price, Utils.LABEL_PREMIUM)
            sentStandardRawData(premium)
        }
    }

    private fun checkPrice(_id: String, _name: String, _price: String, type: String): String {
        val qr = "$_id,$_name,$_price"
        val qrLength = qr.length
        val qrDigits = String.format("%04d", qrLength)
        println(qrDigits)
        return type.replace("^1$", _id)
            .replace("^2$", _name)
            .replace("^3$", _price)
            .replace("^4$", qrDigits)
            .replace("^5$", "$_id,$_name,$_price")
    }

    private fun sentStandardRawData(data: String) {
        try {
            val charset = Charsets.UTF_8
            val encodeValue = Base64.encode(data.toByteArray(charset), Base64.NO_WRAP)
            val encString = String(encodeValue)
            variableMap["__send_data"] = encString.trim()
            variableMap["__encoding"] = "base64"
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val sendData = variableMap["__send_data"]
        val encoding = variableMap["__encoding"]

        HttpManager.getInstance().getApiService().sentDataLocalHostRawData(sendData!!, encoding!!)
            .enqueue(object : retrofit2.Callback<DAOLocalRaw> {
                override fun onFailure(call: retrofit2.Call<DAOLocalRaw>, t: Throwable) {
                    Log.e(Utils.LOG_TAG, "Failure: $t")
                }

                override fun onResponse(call: retrofit2.Call<DAOLocalRaw>, response: Response<DAOLocalRaw>) {
                    if (response.isSuccessful) {
                        Log.i(Utils.LOG_TAG, "Response success:  ${response.message()}")
                        responseRawData(response.body())
                    } else {
                        Log.w(Utils.LOG_TAG, "Response not success: ${response.message()}")
                    }
                }
            })
    }

    private fun responseRawData(body: DAOLocalRaw?) {
        Log.d(
            Utils.LOG_TAG, "Response: " +
                    "[.@productVersion] ${body?.productVersion}\n" +
                    "[message] ${body?.message}\n" +
                    "[result] ${body?.result}\n" +
                    "[function] ${body?.function}\n" +
                    "[.@creationTime] ${body?.creationTime}\n" +
                    "[.@productName] ${body?.productName}"
        )
        when (body?.result) {
            "OK" -> {
                view.showSnackBar("Print Success")
            }
            "NG" -> {
                view.showSnackBar("Print XXX")
            }
        }

    }

}