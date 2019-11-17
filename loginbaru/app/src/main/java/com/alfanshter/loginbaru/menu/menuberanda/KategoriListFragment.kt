package com.alfanshter.loginbaru.menu.menuberanda


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.alfanshter.loginbaru.R
import com.alfanshter.loginbaru.adaptor.CustomBaseAdapter
import kotlinx.android.synthetic.main.fragment_custom_list.*
import kotlinx.android.synthetic.main.fragment_kategori_list.*

/**
 * A simple [Fragment] subclass.
 */
class KategoriListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kategori_list, container, false)
    }




}
