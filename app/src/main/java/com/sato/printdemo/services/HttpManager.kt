package com.sato.printdemo.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class HttpManager {

    private var apiService: APIService

    companion object {
        fun getInstance(): HttpManager {
            return HttpManager()
        }
    }

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .client(OkHttpClient())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()

        apiService = retrofit.create(APIService::class.java)

    }


    fun getApiService(): APIService {
        return apiService
    }

}