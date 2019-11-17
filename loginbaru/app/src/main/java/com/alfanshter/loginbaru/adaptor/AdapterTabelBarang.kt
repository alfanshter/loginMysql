package com.alfanshter.loginbaru.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.alfanshter.loginbaru.Model.ResultItemData
import com.alfanshter.loginbaru.R
import org.jetbrains.anko.find

class AdapterTabelBarang(val dataitems: ArrayList<ResultItemData?>?):BaseAdapter() {
    override fun getView(posisiton: Int, toview: View?, parent: ViewGroup?): View {
    var view =toview
        if ( view == null)
    {
        view = LayoutInflater.from(parent?.context).inflate(R.layout.itemlisttablebarang,parent,false)
    }
        val model = getItem(posisiton) as ResultItemData
        val itemtitle = view?.find<TextView>(R.id.item_title)
           itemtitle?.text = model.namajenis
        //         itemtitle?.text = "${model.namajenis},${model.iduser},"       //mengambil lebih dari satu
        return view!!
    }

    override fun getItem(p0: Int): Any {
    return dataitems?.get(p0)!!
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return dataitems?.size!!
    }


}