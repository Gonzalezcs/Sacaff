package com.example.sacaff.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sacaff.Models.ProximasPartidasModel
import com.example.sacaff.R
import kotlinx.android.synthetic.main.item_proximas_partidas.view.*

class ProximaPartidaAdapter(val lista_proximas_partidaModels:List<ProximasPartidasModel>):RecyclerView.Adapter<ProximaPartidaAdapter.ProximaPartidaHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProximaPartidaHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProximaPartidaHolder(layoutInflater.inflate(R.layout.item_proximas_partidas,parent,false))
    }

    override fun onBindViewHolder(holder: ProximaPartidaHolder, position: Int) {
        holder.render(lista_proximas_partidaModels[position])
    }

    override fun getItemCount(): Int {
        return lista_proximas_partidaModels.size
    }

    class ProximaPartidaHolder(val view: View):RecyclerView.ViewHolder(view) {

        fun render(lista_proximas_partidasModel: ProximasPartidasModel){
            view.titulo_deporte.text =  lista_proximas_partidasModel.tipoDeporte
            view.fecha_partido.text =  lista_proximas_partidasModel.fecha
            view.hora_partido.text =  lista_proximas_partidasModel.horaInicio
            if(lista_proximas_partidasModel.tipoDeporte == "Tenis"){
                view.img_deporte.setImageResource(R.drawable.tenis)
            }else {
                view.img_deporte.setImageResource(R.drawable.futbol)
            }
        }

    }
}