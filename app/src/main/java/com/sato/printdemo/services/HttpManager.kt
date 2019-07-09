package com.sato.printdemo.services

import okhttp3.OkHttpClient
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit

class HttpManager {

    private var apiService: APIService

    companion object {
        fun getInstance(): HttpManager {

            return HttpManager()

        }
    }

    init {

        /*val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://shuttle-bike-management-sut.000webhostapp.com/api/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    apiService = retrofit.create(APIService::class.java)*/

        val retrofit = Retrofit.Builder()
            .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(
                Persister(AnnotationStrategy())
            )
            )
            .baseUrl("http://localhost:8080/")
            .client(OkHttpClient())
            .build()


        /*val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .client(OkHttpClient())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()*/


        /*val retrofit: Retrofit = Retrofit.Builder()
            //.baseUrl("https://shuttle-bike-management-sut.000webhostapp.com/api/")
            .baseUrl("http://localhost:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()*/

        apiService = retrofit.create(APIService::class.java)

    }




    fun getApiService(): APIService {
        return apiService
    }


}