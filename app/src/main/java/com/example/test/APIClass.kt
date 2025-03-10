package com.example.test

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface APIClass{
    @FormUrlEncoded
    @POST("send-otp")
    fun login(@Field("contact_number") contactNumber: String): Call<APIDataClassLogin>

    @FormUrlEncoded
    @POST("verify-otp")
    fun verifyOTP(
        @Field("contact_number") contactNumber: String, @Field("otp") otp: Int
    ): Call<APIDataClassOTP>
}