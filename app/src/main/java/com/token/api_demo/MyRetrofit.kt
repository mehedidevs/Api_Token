package com.token.api_demo

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class MyRetrofit {


    companion object {

        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://174.129.217.127:8080")
                .addConverterFactory(GsonConverterFactory.create())

                .client(client)

                .build()


        }

        private val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build()
    }
}