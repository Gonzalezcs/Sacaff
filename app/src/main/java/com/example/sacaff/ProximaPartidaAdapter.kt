package com.example.sacaff

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_proximas_partidas.view.*

class ProximaPartidaAdapter(val lista_proximas_partidas:List<ProximasPartidas>):RecyclerView.Adapter<ProximaPartidaAdapter.ProximaPartidaHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProximaPartidaHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProximaPartidaHolder(layoutInflater.inflate(R.layout.item_proximas_partidas,parent,false))
    }

    override fun onBindViewHolder(holder: ProximaPartidaHolder, position: Int) {
        holder.render(lista_proximas_partidas[position])
    }

    override fun getItemCount(): Int {
        return lista_proximas_partidas.size
    }

    class ProximaPartidaHolder(val view: View):RecyclerView.ViewHolder(view) {

        fun render(lista_proximas_partidas:ProximasPartidas){
            view.titulo_deporte.text =  lista_proximas_partidas.tipoDeporte
            view.fecha_partido.text =  lista_proximas_partidas.fecha
            view.hora_partido.text =  lista_proximas_partidas.horaInicio
            if(lista_proximas_partidas.tipoDeporte == "Tenis"){
                view.img_deporte.setImageResource(R.drawable.tenis)
            }else {
                view.img_deporte.setImageResource(R.drawable.futbol)
            }
        }

    }
}