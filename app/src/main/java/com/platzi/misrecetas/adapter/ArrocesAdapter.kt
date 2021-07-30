package com.platzi.misrecetas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.platzi.misrecetas.R
import com.platzi.misrecetas.model.Recetas

class ArrocesAdapter(private val arrocesListener: ArrocesListener) : RecyclerView.Adapter<ArrocesAdapter.ViewHolder>() {
    var listArroces = ArrayList<Recetas>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recetas_sencillas,parent,false))
    override fun getItemCount() = listArroces.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val arroces = listArroces[position]
        holder.tvNombreReceta.text = arroces.nombreRecetas
        holder.tvCategoria.text = arroces.categoria
        Glide.with(holder.itemView.context)
                .load(arroces.fotoRecetas)
            .apply(RequestOptions.circleCropTransform())
                .into(holder.ivComida)
        holder.itemView.setOnClickListener{
            arrocesListener.onArrocesClicked(arroces,position)
        }
    }
    fun updateData(data: List<Recetas>){
        listArroces.clear()
        listArroces.addAll(data)
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ivComida = itemView.findViewById<ImageView>(R.id.ivComida)
        val tvNombreReceta = itemView.findViewById<TextView>(R.id.tvNombreReceta)
        val tvCategoria = itemView.findViewById<TextView>(R.id.tvCategoria)

    }
}