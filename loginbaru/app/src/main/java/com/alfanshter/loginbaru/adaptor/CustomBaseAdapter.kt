package com.alfanshter.loginbaru.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.alfanshter.loginbaru.Model.ResultItemData
import com.alfanshter.loginbaru.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemcustom.view.*

class CustomBaseAdapter(val  context:Context, val DataItem:ArrayList<ResultItemData>):BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var v =convertView
        if (v ==null)
        {
            v = LayoutInflater.from(context).
                inflate(R.layout.itemcustom, parent, false);
        }

        var data = getItem(position) as ResultItemData
        val imageView:ImageView = v!!.findViewById(R.id.gambar)
        val textview:TextView = v!!.findViewById(R.id.textview)
        val harga:TextView = v!!.findViewById(R.id.harga)
        Picasso.get().load("https://cdns.klimg.com/merdeka.com/i/w/news/2019/03/07/1058424/670x335/pria-ceko-tewas-diterkam-singa-peliharaan.jpg")
            .into(imageView)

        textview.text = data?.id
        harga.text = data?.namajenis
        return v
    }

    override fun getItem(position: Int): Any {
        return DataItem.get(position)
    }

    override fun getItemId(position: Int): Long {
        return DataItem.get(position).toString().toLong()
    }

    override fun getCount(): Int {
        return DataItem.size

    }
}