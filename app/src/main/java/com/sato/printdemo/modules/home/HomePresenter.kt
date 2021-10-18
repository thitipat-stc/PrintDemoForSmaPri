package com.sato.printdemo.modules.home

import android.content.Context
import android.util.Base64
import android.util.Base64.NO_WRAP
import android.util.Log
import com.sato.printdemo.dao.smapri.DAODataPort
import com.sato.printdemo.dao.smapri.DAOLocalNull
import com.sato.printdemo.dao.smapri.DAOLocalRaw
import com.sato.printdemo.services.HttpManager
import com.sato.printdemo.util.Utils
import retrofit2.Response

class HomePresenter(views: HomeConstructor.HomeSetView, val context: Context) : HomeConstructor.HomeSetPresenter {

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

        //val theString = "AH0100V0100L0102XM" + message.trim() + "Q1Z"
        //val theString = "AAPSWKSampleStandardLa%2H0413V00580L0101P02CEUTF-8SSATOAUTO-ID(THAILAND)CO.,LTD.ST0001,CL4NX,3500Q1Z"
        /*val theString = "A" +
                "APSWKSampleStandardLa" +
                "%2H0413V00580L0101P02CEUTF-8SSATOAUTO-ID(THAILAND)CO.,LTD." +
                "ST0001,CL4NX,3500" + "Q1Z"*/

        //val standard = context.resources.getString(R.string.label_standard)
        //val format = String.format(standard,"ST001")

        val id = "ST00997"
        val name = "CX6NL"
        val price = "98658"
        val outReplace = Utils.LABEL_STANDARD.replace("^1$", id).replace("^2$", name).replace("^3$", price)
            .replace("^4$", "$id,$name,$price")

        try {
            val charset = Charsets.UTF_8
            val encodeValue = Base64.encode(
                outReplace.toByteArray(charset),
                NO_WRAP
            )
            // 2019-07-11 23:12:35.235 10694-10694/com.sato.printdemo E/SSSSSSSSSS:: XXXL: G0EbQRtQUxtXS1NhbXBsZVN0YW5kYXJkTGEbJTIbSDA0MTMbVjAwNTgwG0wwMTAxG1AwMhtDRVVURi04G1NTQVRPQVVUTy1JRChUSEFJTEFORClDTy4sTFRELlNUMDAwMSxDTDROWCwzNTAwG1ExG1o=
            //val encodeValue = Base64.encode(theString.toByteArray(charset), URL_SAFE)
            // 2019-07-11 23:20:26.746 11217-11217/com.sato.printdemo E/SSSSSSSSSS:: XXXL: G0EbQRtQUxtXS1NhbXBsZVN0YW5kYXJkTGEbJTIbSDA0MTMbVjAwNTgwG0wwMTAxG1AwMhtDRVVU
            // Ri04G1NTQVRPQVVUTy1JRChUSEFJTEFORClDTy4sTFRELlNUMDAwMSxDTDROWCwzNTAwG1ExG1o=
            val encString = String(encodeValue)
            println(encString)

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