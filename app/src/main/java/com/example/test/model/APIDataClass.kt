package com.example.test.model

import java.io.Serializable

data class APIDataClassOTP(
    val data: Data, val meta: Meta
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
    val interests: List<String>,
    val profile_photo: String,
    val total_followers: Int,
    val total_followings: Int,
): Serializable

data class Meta(
    val message:String
)

//day2
data class EditProfile(
    val id:Int,
    val message:String,
    val name:String,
    val email:String,
    val contact_number :String,
    val dob : String,
    val bio: String,
    val gender:String,
    val latitude : Double,
    val longitude: Double,
    val fitness_level: String,
    val interests: List<String>,
    val profile_photo: String,
    val registered_at: String,
    val total_followers: Int,
    val total_followings: Int,
    val is_following :Int,
    val is_blocked: Int,
    val share_location: Int
)