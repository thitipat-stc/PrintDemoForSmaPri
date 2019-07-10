package com.sato.printdemo.services

import com.sato.printdemo.dao.smapri.DAOLocalNull
import com.sato.printdemo.dao.smapri.DAODataPort
import com.sato.printdemo.dao.smapri.DAOLocalRaw
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface APIService {

    @GET("Printer/Port")
    fun getDataLocalHostNull(): Call<DAOLocalNull>

    @GET("Printer/SendRawData")
    fun sentDataLocalHostRawData(
        @Query("__send_data") sendData: String,
        @Query("__encoding") encoding: String
    ): Call<DAOLocalRaw>

    @GET("Printer/SetPort")
    fun setDataPort(
        @Query("__device_type") sendData: String,
        @Query("__address") address: String,
        @Query("__protocol") protocol: String,
        @Query("__crc") crc: String
    ): Call<DAODataPort>

}