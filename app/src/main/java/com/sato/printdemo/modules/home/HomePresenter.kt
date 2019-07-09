package com.sato.printdemo.modules.home

import android.util.Log
import com.sato.printdemo.dao.DAOData
import com.sato.printdemo.dao.DAOPort
import com.sato.printdemo.services.HttpManager
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

        HttpManager.getInstance().getApiService().getPort().enqueue(object : retrofit2.Callback<DAOPort> {
            override fun onFailure(call: retrofit2.Call<DAOPort>, t: Throwable) {
                Log.e("LogTest ", t.toString())
            }

            override fun onResponse(call: retrofit2.Call<DAOPort>, response: Response<DAOPort>) {
                if (response.isSuccessful) {
                    //ddddd(response.body())
                    Log.e("kkkk: ", "success" + response.message())
                } else {
                    Log.e("dddd: ", "Not success" + response.message())
                }
            }
        })
    }

    private fun ddddd(body: DAOPort?) {

        //Log.e("sdsdsdsdssdsdsssd", "${body?.response?.code}//")

        /*val size = body?.contacts?.size
        for (i in 0 until size!!) {
            //String s = daoData.getCategories().get(i).getName();
            val name = body.contacts!![i].name
            val gender = body.contacts!![i].phone!!.mobile
            Log.e("sdsdsdsdssdsdsssd", "$name - $gender//")
        }*/

    }

}