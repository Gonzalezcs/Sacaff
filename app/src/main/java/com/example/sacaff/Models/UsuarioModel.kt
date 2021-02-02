package com.example.sacaff.Models

data class UsuarioModel(
    val apellido_materno: String,
    val apellido_paterno: String,
    val correo: String,
    val fecha_nacimiento: String,
    val id_usuario: Int,
    val primer_nombre: String,
    val rut: String,
    val segundo_nombre: String,
    val sexo: String,
    val telefono: String
)