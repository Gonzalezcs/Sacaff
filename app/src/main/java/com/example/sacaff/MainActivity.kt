package com.example.sacaff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var correo_usuario = findViewById(R.id.correo_usuario) as TextInputLayout
        var password_usuario = findViewById(R.id.password_usuario) as TextInputLayout
        var boton_entrar = findViewById(R.id.boton_entrar) as Button

        // set on-click listener
        boton_entrar.setOnClickListener {
            val user_name = correo_usuario.editText?.text.toString()
            val password = password_usuario.editText?.text.toString();

            val intent = Intent(this, MenuPrincipalActivity::class.java)
            startActivity(intent)

        }
    }
}