package com.example.sacaff.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import com.example.sacaff.BodyPosts.BodyRegistroModel
import com.example.sacaff.BodyPosts.bodyLoginModel
import com.example.sacaff.Models.LoginModel
import com.example.sacaff.Models.RegistroModel
import com.example.sacaff.R
import com.example.sacaff.Services.LoginService
import com.example.sacaff.Services.RegistroService
import com.example.sacaff.Utils.RestEngine
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_registro_usuario.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistroUsuarioActivity : AppCompatActivity() {

    private var correo:String = ""
    private var password:String = ""
    private var password2:String = ""
    private var primer_nombre:String = ""
    private var segundo_nombre:String = ""
    private var apellido_paterno:String = ""
    private var apellido_materno:String = ""
    private var sexo:String = ""
    private var rut:String = ""
    private var telefono:String = ""
    private var fecha_nacimiento:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_usuario)

        val items = listOf("Masculino", "Femenino")
        val adapter = ArrayAdapter(applicationContext, R.layout.tv_entity, items)
        (input_sexo.editText as? AutoCompleteTextView)?.setAdapter(adapter)

    }

    fun registarse(view: View){

        correo = input_correo.editText?.text.toString()
        password = input_password.editText?.text.toString()
        password2 = input_repetir_password.editText?.text.toString()
        primer_nombre = input_primer_nombre.editText?.text.toString()
        segundo_nombre = input_segundo_nombre.editText?.text.toString()
        apellido_paterno = input_apellido_paterno.editText?.text.toString()
        apellido_materno = input_apellido_materno.editText?.text.toString()
        sexo = input_sexo.editText?.text.toString()
        rut = input_rut.editText?.text.toString()
        telefono = input_telefono.editText?.text.toString()
        fecha_nacimiento = input_fecha_nac.editText?.text.toString()

        if(password == password2){
            llamar_api_registro()
        }else{
            Toast.makeText(this@RegistroUsuarioActivity,"Contraseñas no coindicen", Toast.LENGTH_LONG).show()
        }

        val services: RegistroService = RestEngine.getRestEngine().create(RegistroService::class.java)
        var body = BodyRegistroModel(correo = correo,password = password,primer_nombre = primer_nombre,segundo_nombre = segundo_nombre,apellido_paterno = apellido_paterno,
                                    apellido_materno = apellido_materno,sexo = sexo,rut = rut,telefono = telefono,fecha_nacimiento = fecha_nacimiento)
        val result: Call<RegistroModel> = services.registroPost(body)

        result.enqueue(object : Callback<RegistroModel> {


            override fun onResponse(call: Call<RegistroModel>, response: Response<RegistroModel>) {
                if (response.body()!!.status) {
                    Toast.makeText(this@RegistroUsuarioActivity,"Correcto registro", Toast.LENGTH_LONG).show()

                }else{
                    Toast.makeText(this@RegistroUsuarioActivity,"Correo o Contraseña incorrecto", Toast.LENGTH_LONG).show()
                }


            }
            override fun onFailure(call: Call<RegistroModel>, t: Throwable) {
                Toast.makeText(this@RegistroUsuarioActivity,"Error en la red", Toast.LENGTH_LONG).show()
            }


        })
    }

    fun llamar_api_registro(){

    }
}