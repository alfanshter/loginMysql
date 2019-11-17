package com.alfanshter.loginbaru.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager

import com.alfanshter.loginbaru.R
import com.alfanshter.loginbaru.adaptor.ViewPagerAdapterList
import com.alfanshter.loginbaru.menu.menuberanda.Beranda
import com.alfanshter.loginbaru.menu.menuberanda.JenisListFragment
import com.alfanshter.loginbaru.menu.menuberanda.Kategori
import com.alfanshter.loginbaru.menu.menuberanda.KategoriListFragment
import kotlinx.android.synthetic.main.fragment_beranda2.*
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class BerandaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager(viewberanda, fragmentManager)
        tabsberanda.setupWithViewPager(viewberanda)

    }

    fun setupViewPager(vciewPager: ViewPager, manager: FragmentManager?)
    {
        var adapter : ViewPagerAdapterList = ViewPagerAdapterList(manager)
        adapter.addFragment(Beranda(), "Jenis")
        adapter.addFragment(Kategori(), "Kategori")
        vciewPager.adapter = adapter
    }



}
