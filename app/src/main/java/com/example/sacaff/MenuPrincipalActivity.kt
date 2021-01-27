package com.example.sacaff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

class MenuPrincipalActivity : AppCompatActivity() {

    val proximas_partidas = listOf(
        ProximasPartidas("Tenis","30-01-2021","08:00"),
        ProximasPartidas("Futbol","20-02-2021","09:00"),
        ProximasPartidas("Tenis","13-02-2021","11:00"),
        ProximasPartidas("Tenis","14-2021","12:30"),
        ProximasPartidas("Futbol","30-01-2021","14:00"),
        ProximasPartidas("Tenis","30-01-2021","12:00"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        //a
        //val asdf = findViewById<>(R.id.recycler_proximas_partidas).layoutManager = LinearLayoutManager(this)


    }
}