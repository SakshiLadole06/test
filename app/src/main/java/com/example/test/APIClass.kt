package com.example.test

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIClass{
    @GET
    fun getOTP()

//    @POST("auth/login")
//    fun postOTP(@Body)
}