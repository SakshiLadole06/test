package com.example.test.model

import android.content.Context
import com.example.test.APIClass
import com.example.test.AuthIntercepter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ObjectRetrofit(context: Context) {
    val url="https://strengthen-numbers-stag.dev-imaginovation.net/api/"
    val authIntercepter = AuthIntercepter(context)

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(authIntercepter)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getAPIService(): APIClass {
        return retrofit.create(APIClass::class.java)
    }
}

