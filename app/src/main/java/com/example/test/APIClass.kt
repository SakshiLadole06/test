package com.example.test

import com.example.test.model.APIDataClassLogin
import com.example.test.model.APIDataClassOTP
import com.example.test.model.EditProfile
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIClass{
    @FormUrlEncoded
    @POST("v2/send-otp")
    fun login(@Field("contact_number") contactNumber: String): Call<APIDataClassLogin>

    @FormUrlEncoded
    @POST("v1/verify-otp")
    fun verifyOTP(
        @Field("contact_number") contactNumber: String, @Field("otp") otp: Int
    ): Call<APIDataClassOTP>

    @FormUrlEncoded
    @POST("edit-profile")
    fun editProfile(

    ):Call<EditProfile>
}