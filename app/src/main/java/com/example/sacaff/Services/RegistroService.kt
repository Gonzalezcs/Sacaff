package com.example.sacaff.Services

import com.example.sacaff.BodyPosts.BodyRegistroModel
import com.example.sacaff.Models.RegistroModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistroService {
    @POST("/registro")
    fun registroPost(@Body bodyRegistroModel: BodyRegistroModel): Call<RegistroModel>
}