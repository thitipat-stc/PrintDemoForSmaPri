package com.sato.printdemo.modules.home

import android.util.Log
import com.sato.printdemo.dao.smapri.DAODataPort
import com.sato.printdemo.dao.smapri.DAOLocalNull
import com.sato.printdemo.dao.smapri.DAOLocalRaw
import com.sato.printdemo.services.HttpManager
import com.sato.printdemo.util.Utils
import retrofit2.Response
import android.util.Base64.NO_WRAP
import android.R.attr.data
import android.util.Base64
import android.util.Base64.URL_SAFE
import java.io.UnsupportedEncodingException


class HomePresenter(views: HomeConstructor.HomeSetView) : HomeConstructor.HomeSetPresenter {


    private val view = views
    private val variableMap: HashMap<String, String> = HashMap()
    private val mockUpStr: String =
        "AhtBG0EzViswMDBIKzAwMBtDUzYbI0Y1G0ExVjAwNDA2SDA0MDYbWgMbIyMDHCAgICAgASAgICAgICAgICAgICAgICAgICAgICAgAhtBG1BTG1dLMngyMjAzZHBpGyUyG0gwMzc3G1YwMDM0NRtQMDIbUkRBQDAsMDE0LDAxNCxUUkFDS0lORyAjOiAgIDFaIDEyMyA0NUUgMDMgMDAwMCAwMDQ3GyUwG0gwMDI2G1YwMDM3ORtGVzA1SDAzNTEbJTIbSDAzNzcbVjAwMzc0G1AwMhtSREFAMSwwMzUsMDM2LFVQUyBHUk9VTkQbJTAbSDAwMjQbVjAwMTc0G0ZXMDVIMDM1MRslMhtIMDM4NRtWMDAxNjYbUDAyG1JEQUAwLDAxMiwwMTEsU1RBVElPTjQgIFBSSU5URVIxMjM0IFVTICAyMTE0ICBKQU4gMTMgMTE6MjA6MjEgMjAxNCBURVNUIDEuMi4zIFNBVE8bJTIbSDAzODAbVjAwMzIzG0JHMDExMDQ+SDFaIDEyMyA0NUUgMDMgPkMwMDAwPkQgPkMwMDQ3PkUgICAgICAbJTIbSDAyNTkbVjAwMjE5G1AwMhtSREJAMCwwMTAsMDEwLDFaIDEyMyA0NUUgMDMgMDAwMCAwMDQ3ICAgICAgGyUyG0gwMzM1G1YwMDE0NRsyRDEyLDA1LDA1LDAyLDIzG0ROMDA0OSxSSU5URVIxMjM0IFVTICAgMjExNCAgIEpBTiAxMyAxMToyMDoyMSAyMDE0DQoNCg0KG1ExG1oDGyMjBCAgGyMjBSAg"

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
        val theString = "A" +
                "APSWKSampleStandardLa" +
                "%2H0413V00580L0101P02CEUTF-8SSATOAUTO-ID(THAILAND)CO.,LTD." +
                "ST0001,CL4NX,3500" + "Q1Z"

        try {
            val charset = Charsets.UTF_8
            val encodeValue = Base64.encode(theString.toByteArray(charset), NO_WRAP) // 2019-07-11 23:12:35.235 10694-10694/com.sato.printdemo E/SSSSSSSSSS:: XXXL: G0EbQRtQUxtXS1NhbXBsZVN0YW5kYXJkTGEbJTIbSDA0MTMbVjAwNTgwG0wwMTAxG1AwMhtDRVVURi04G1NTQVRPQVVUTy1JRChUSEFJTEFORClDTy4sTFRELlNUMDAwMSxDTDROWCwzNTAwG1ExG1o=
            //val encodeValue = Base64.encode(theString.toByteArray(charset), URL_SAFE) // 2019-07-11 23:20:26.746 11217-11217/com.sato.printdemo E/SSSSSSSSSS:: XXXL: G0EbQRtQUxtXS1NhbXBsZVN0YW5kYXJkTGEbJTIbSDA0MTMbVjAwNTgwG0wwMTAxG1AwMhtDRVVU
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