package com.alfanshter.loginbaru.adaptor

import android.content.Context
import android.graphics.ColorSpace
import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alfanshter.loginbaru.Model.ResultItemData
import com.alfanshter.loginbaru.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import org.jetbrains.anko.image

class RecyclerviewAdapter(val context: Context,val dataItem: ArrayList<ResultItemData>, private val listener: (ResultItemData) -> Unit):RecyclerView.Adapter<RecyclerviewAdapter.viewholder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.itemcustom,parent,false)
        return viewholder(view)
    }

    override fun getItemCount(): Int {
       return dataItem.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
    holder.setdata(dataItem.get(position),listener)
    }

    class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.find<TextView>(R.id.textview)
        val titleharga = itemView.find<TextView>(R.id.harga)
        val titlegambar = itemView.find<ImageView>(R.id.gambar)
        fun setdata(model: ResultItemData, listener: (ResultItemData) -> Unit)
        {
            title.text = model.id
            titleharga.text = model.nama
            Picasso.get().load("http://192.168.137.42/${model.gambar}").into(titlegambar)
            itemView.setOnClickListener{listener(model)}
        }

    }

}