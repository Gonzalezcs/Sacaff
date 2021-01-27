package com.example.sacaff

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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
            view.findViewById<TextView>(R.id.titulo_deporte).text = lista_proximas_partidas.tipoDeporte
            view.findViewById<TextView>(R.id.fecha_partido).text = lista_proximas_partidas.fecha
            view.findViewById<TextView>(R.id.hora_partido).text = lista_proximas_partidas.horaInicio
        }

    }
}