package com.example.mydemo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {


    companion object {

        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://174.129.217.127:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        }
    }
}