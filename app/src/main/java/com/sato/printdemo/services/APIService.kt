package com.sato.printdemo.services

import com.sato.printdemo.dao.DAOData
import com.sato.printdemo.dao.DAOPort
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface APIService {

    @GET("contacts")
    fun getData(): Call<DAOData>

    @GET("Printer/Port")
    //fun getPort(@Body getPort: CheckPort): Call<DAOData>
    fun getPort(): Call<DAOPort>

    //@POST("mode/{mode}")
    //fun setMode(@Path("mode") mode: String): Call<DAOAlertResponse>

}