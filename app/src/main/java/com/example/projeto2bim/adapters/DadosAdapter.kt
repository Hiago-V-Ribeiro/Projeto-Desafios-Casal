package com.example.projeto2bim.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto2bim.R
import com.example.projeto2bim.models.DispositivosModelo

class DadosAdapter (private val dispList: ArrayList<DispositivosModelo>) :
    RecyclerView.Adapter<DadosAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.informa, parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentDisp = dispList[position]
        holder.tvCmFav.text = currentDisp.comifavo
        holder.tvFlmFav.text = currentDisp.filmefavo
        holder.tvSrFav.text = currentDisp.seriefavo
        holder.tvMscFav.text = currentDisp.musicfavo
        holder.tvAler.text = currentDisp.alergias
        holder.tvCmRuim.text = currentDisp.comidaruim
    }

    override fun getItemCount(): Int {
        return dispList.size
    }

    class ViewHolder(itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val tvCmFav : TextView = itemView.findViewById(R.id.textcomifav)
        val tvFlmFav : TextView = itemView.findViewById(R.id.textfilmfav)
        val tvSrFav : TextView = itemView.findViewById(R.id.textseriefav)
        val tvMscFav : TextView = itemView.findViewById(R.id.textmusifav)
        val tvAler : TextView = itemView.findViewById(R.id.textalergias)
        val tvCmRuim : TextView = itemView.findViewById(R.id.textcomiruim)

        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }

    }

}