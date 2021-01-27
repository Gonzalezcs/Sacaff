package com.example.sacaff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home_futbol.*
import kotlinx.android.synthetic.main.fragment_home_futbol.view.*

class homeFutbolFragment(private val lista: List<ProximasPartidas>) : Fragment() {

    private var gridLayoutManager: GridLayoutManager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home_futbol, container, false)

        gridLayoutManager = GridLayoutManager(context,2, LinearLayoutManager.VERTICAL,false)
        view.recycler_futbol.layoutManager = gridLayoutManager
        view.recycler_futbol.setHasFixedSize(true)

        val adapter = ProximaPartidaAdapter(lista)
        view.recycler_futbol.adapter = adapter


        return view

    }

}