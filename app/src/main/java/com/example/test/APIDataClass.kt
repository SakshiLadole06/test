package com.example.test

data class APIDataClassOTP(
    val data:Data,val meta:Meta
)

data class APIDataClassLogin(
    val data: String?,
    val meta: Meta
)

data class Data(
    val id:Int,
    val name:String,
    val email:String,
    val contact_number :String,
    val dob : String,
    val bio: String,
    val gender:String,
    val latitude : String,
    val longitude: String,
    val fitness_level: String,
    val interests: String,
    val profile_photo: String
)

data class Meta(
    val message:String
)