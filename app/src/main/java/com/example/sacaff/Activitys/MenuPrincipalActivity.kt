package com.example.sacaff.Activitys


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.FragmentTransaction
import com.example.sacaff.Models.ProximasPartidasModel
import com.example.sacaff.R
import com.example.sacaff.Fragments.homeFutbolFragment
import com.example.sacaff.Fragments.homeTenisFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuPrincipalActivity : AppCompatActivity() {



    private val proximas_partidas_tenis = listOf(
        ProximasPartidasModel("Tenis","30-01-2021","08:00"),
        ProximasPartidasModel("Tenis","13-02-2021","11:00"),
        ProximasPartidasModel("Tenis","14-2021","12:30"),
        ProximasPartidasModel("Tenis","30-01-2021","12:00"),
    )

    private val proximas_partidas_futbol = listOf(
            ProximasPartidasModel("Futbol","20-02-2021","09:00"),
            ProximasPartidasModel("Futbol","31-01-2021","14:00"),
            ProximasPartidasModel("Futbol","12-02-2021","13:00"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE

        lateinit var homeTenisFragment: homeTenisFragment
        lateinit var homeFutbolFragment: homeFutbolFragment

        homeTenisFragment = homeTenisFragment(proximas_partidas_tenis)
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,homeTenisFragment).setTransition(
            FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
        val bottomnav : BottomNavigationView = findViewById(R.id.BottomNavMenu)

        bottomnav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.tenis_item -> {
                    homeTenisFragment = homeTenisFragment(proximas_partidas_tenis)
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout,homeTenisFragment).setTransition(
                        FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }

                R.id.futbol_item -> {
                    homeFutbolFragment = homeFutbolFragment(proximas_partidas_futbol)
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout,homeFutbolFragment).setTransition(
                        FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
            }
            true
        }





    }
}