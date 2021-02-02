package com.example.sacaff.Services

import com.example.sacaff.Models.LoginModel
import com.example.sacaff.BodyPosts.bodyLoginModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("/login")
    fun loginPost(@Body bodyLoginModel: bodyLoginModel): Call<LoginModel>
}