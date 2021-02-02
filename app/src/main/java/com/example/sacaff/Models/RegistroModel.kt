package com.example.sacaff.Models

data class RegistroModel(
    val correo_validate: Boolean,
    val registro: UsuarioModel,
    val rut_validate: Boolean,
    val status: Boolean,
    val telefono_validate: Boolean
)