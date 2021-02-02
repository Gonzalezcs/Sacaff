package com.example.sacaff.Activitys

 import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
 import android.widget.Button
import android.widget.Toast
 import com.example.sacaff.Models.LoginModel
 import com.example.sacaff.BodyPosts.bodyLoginModel
 import com.example.sacaff.Services.LoginService
 import com.example.sacaff.R
 import com.example.sacaff.Utils.RestEngine
 import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_menu_principal.*
 import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var correo_usuario = findViewById<TextInputLayout>(R.id.correo_usuario)
        var password_usuario = findViewById<TextInputLayout>(R.id.password_usuario)
        var boton_entrar = findViewById<Button>(R.id.boton_entrar)

        // set on-click listener
        boton_entrar.setOnClickListener {
            val user_name = correo_usuario.editText?.text.toString()
            val password = password_usuario.editText?.text.toString();

            val services: LoginService = RestEngine.getRestEngine().create(LoginService::class.java)
            var body = bodyLoginModel(user_name,password)
            val result: Call<LoginModel> = services.loginPost(body)

            result.enqueue(object : Callback<LoginModel>{


                override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                    if (response.body()!!.status) {
                        Toast.makeText(this@MainActivity,"Correcto login",Toast.LENGTH_SHORT).show()
                        goacti()
                    }else{
                        Toast.makeText(this@MainActivity,"Correo o Contraseña incorrecto",Toast.LENGTH_SHORT).show()
                    }


                }
                override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                    Toast.makeText(this@MainActivity,"Error en la red",Toast.LENGTH_SHORT).show()
                }


            })



        }
    }

    fun goacti(){
        val intent = Intent(this, RegistroUsuarioActivity::class.java)
        startActivity(intent)
    }
}