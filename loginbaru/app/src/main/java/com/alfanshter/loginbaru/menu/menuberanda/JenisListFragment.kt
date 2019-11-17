package com.alfanshter.loginbaru.menu.menuberanda


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.alfanshter.loginbaru.R

/**
 * A simple [Fragment] subclass.
 */
class JenisListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jenis_list, container, false)
    }


}
