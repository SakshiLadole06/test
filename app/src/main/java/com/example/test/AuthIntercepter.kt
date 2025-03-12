package com.example.test

import android.content.Context
import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class AuthIntercepter(private val context: Context):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //for token
        val sp = context.getSharedPreferences("token", Context.MODE_PRIVATE)
        val token = sp.getString("auth_token", null)

        val req = chain.request().newBuilder()
            .addHeader("Content-Type", "application/json")
            token?.let {
                req.addHeader("X-Authorization-Token", it)
            }
        return chain.proceed(req.build())
    }

    fun httpClient(): OkHttpClient {
        val client = OkHttpClient().newBuilder()
            .addInterceptor(AuthIntercepter(context))
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        return client.build()
    }
}



