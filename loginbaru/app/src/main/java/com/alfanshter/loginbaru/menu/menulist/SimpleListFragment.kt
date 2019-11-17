package com.alfanshter.loginbaru.menu.menulist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.alfanshter.loginbaru.R
import kotlinx.android.synthetic.main.fragment_simple_list.*

/**
 * A simple [Fragment] subclass.
 */
class SimpleListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_list, container, false)
    }

    var dataitem = arrayListOf("hello1","hello2")
    private lateinit var adapter: ArrayAdapter<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = ArrayAdapter(context!!,android.R.layout.simple_list_item_1,dataitem)

        listview.adapter = adapter
        add.setOnClickListener {
            dataitem.add("HelloTambah")
            adapter.notifyDataSetChanged()

        }


    }
}
