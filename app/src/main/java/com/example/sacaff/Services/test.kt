package com.example.sacaff.Services

import com.example.sacaff.Models.UsuarioModel
import retrofit2.Call
import retrofit2.http.GET

interface test {
    @GET("/usuario/1")
    fun getLogin(): Call<UsuarioModel>
}