package com.example.sacaff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import kotlinx.android.synthetic.main.activity_registro_usuario.*

class RegistroUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_usuario)

        val items = listOf("Masculino", "Femenino")
        val adapter = ArrayAdapter(applicationContext, R.layout.tv_entity, items)
        (input_sexo.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    }
}