package com.alfanshter.loginbaru.menu.menulist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alfanshter.loginbaru.Model.ResultItemData

import com.alfanshter.loginbaru.R
import com.alfanshter.loginbaru.adaptor.CustomBaseAdapter
import kotlinx.android.synthetic.main.fragment_custom_list.*

/**
 * A simple [Fragment] subclass.
 */
class CustomListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_list, container, false)

    }

    private  lateinit var  customBaseAdapter: CustomBaseAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var arrayList:ArrayList<ResultItemData> = arrayListOf()


        arrayList.add(ResultItemData(id = "1",namajenis = "singa"))
        arrayList.add(ResultItemData(namajenis = "singa",id = "65"))
        

        customBaseAdapter = CustomBaseAdapter(context!!,arrayList)
        listviewbaru.adapter = customBaseAdapter


    }



}
