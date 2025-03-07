package com.example.test

import android.os.Message

data class APIDataClass(
    val data:Data,val meta:Meta
)
data class Data(
    val id:Int,
    val name:String,
    val email:String,
    val mo_no:String,
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