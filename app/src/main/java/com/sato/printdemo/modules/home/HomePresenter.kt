package com.sato.printdemo.modules.home

import android.util.Log
import com.sato.printdemo.dao.smapri.DAOLocal
import com.sato.printdemo.services.HttpManager
import com.sato.printdemo.util.Utils
import retrofit2.Response

class HomePresenter(views: HomeConstructor.HomeSetView) : HomeConstructor.HomeSetPresenter {

    private val view = views

    /*override fun getData() {
        HttpManager.getInstance().getApiService().getData().enqueue(object : retrofit2.Callback<DAOData> {
            override fun onFailure(call: retrofit2.Call<DAOData>, t: Throwable) {
                Log.e("LogTest ", "3")
            }

            override fun onResponse(call: retrofit2.Call<DAOData>, response: Response<DAOData>) {
                if (response.isSuccessful) {
                    view.getDataSuccess(response.body())
                } else {
                    Log.e("dddd: ", "Not success" + response.message())
                }
            }
        })
    }*/

    override fun printItem(message: String) {
        /*val theString = "AH0100V0100L0102XM" + message.trim() + "Q1Z"
        try {
            val encodeValue = android.util.Base64.encode(theString.toByteArray(), android.util.Base64.URL_SAFE)
            var encString = String(encodeValue)
            //Utils.showToast(this, "KKL + $encodeValue")
        } catch (e: Exception) {
            e.printStackTrace()
        }*/

        HttpManager.getInstance().getApiService().getDataLocalHost().enqueue(object : retrofit2.Callback<DAOLocal> {
            override fun onFailure(call: retrofit2.Call<DAOLocal>, t: Throwable) {
                Log.e(Utils.LOG_TAG, "Failure: $t")
            }

            override fun onResponse(call: retrofit2.Call<DAOLocal>, response: Response<DAOLocal>) {
                if (response.isSuccessful) {
                    Log.i(Utils.LOG_TAG, "Response success:  ${response.message()}")
                    checkResponse(response.body())
                } else {
                    Log.w(Utils.LOG_TAG, "Response not success: ${response.message()}")
                }
            }
        })
    }

    private fun checkResponse(body: DAOLocal?) {
        Log.d(Utils.LOG_TAG, "Response: ${body?.version} ${body?.message} ${body?.function}")
    }

}