package com.sato.printdemo.services

import com.sato.printdemo.dao.DAOData
import com.sato.printdemo.dao.smapri.DAOLocal
import retrofit2.Call
import retrofit2.http.GET


interface APIService {

    @GET("contacts")
    fun getData(): Call<DAOData>

    @GET("Printer/Port")
    fun getDataLocalHost(): Call<DAOLocal>

}