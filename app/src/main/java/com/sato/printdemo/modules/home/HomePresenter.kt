package com.sato.printdemo.modules.home

import android.util.Log
import com.sato.printdemo.dao.smapri.DAODataPort
import com.sato.printdemo.dao.smapri.DAOLocalNull
import com.sato.printdemo.dao.smapri.DAOLocalRaw
import com.sato.printdemo.services.HttpManager
import com.sato.printdemo.util.Utils
import retrofit2.Response

class HomePresenter(views: HomeConstructor.HomeSetView) : HomeConstructor.HomeSetPresenter {


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

    override fun printItem(message: String) {

        val theString = "AH0100V0100L0102XM" + message.trim() + "Q1Z"
        try {
            val encodeValue = android.util.Base64.encode(theString.toByteArray(), android.util.Base64.URL_SAFE)
            val encString = String(encodeValue)
            variableMap["__send_data"] = encString.trim()
            variableMap["__encoding"] = "base64"
            sentDataLocalHostRawData(variableMap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun sentDataLocalHostRawData(variableMap: HashMap<String, String>) {

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

    override fun setDataPort(__device_type: String, __address: String, __protocol: String, __crc: String) {

        HttpManager.getInstance().getApiService().setDataPort(__device_type, __address, __protocol, __crc)
            .enqueue(object : retrofit2.Callback<DAODataPort> {
                override fun onFailure(call: retrofit2.Call<DAODataPort>, t: Throwable) {
                    Log.e(Utils.LOG_TAG, "Failure: $t")
                }

                override fun onResponse(call: retrofit2.Call<DAODataPort>, response: Response<DAODataPort>) {
                    if (response.isSuccessful) {
                        Log.i(Utils.LOG_TAG, "Response success:  ${response.message()}")
                        responsePort(response.body())
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
        view.showSnackBar()
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
        view.showSnackBar()
    }

    private fun responsePort(body: DAODataPort?) {
        Log.d(
            Utils.LOG_TAG, "Response: " +
                    "[.@productVersion] ${body?.productVersion}\n" +
                    "[message] ${body?.message}\n" +
                    "[result] ${body?.result}\n" +
                    "[function] ${body?.function}\n" +
                    "[.@creationTime] ${body?.creationTime}\n" +
                    "[.@productName] ${body?.productName}"
        )
        view.showSnackBar()
    }

}