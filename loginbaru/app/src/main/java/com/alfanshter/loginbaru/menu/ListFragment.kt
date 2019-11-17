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
import com.alfanshter.loginbaru.menu.menulist.CustomListFragment
import com.alfanshter.loginbaru.menu.menulist.SimpleListFragment
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager(viewpager, fragmentManager)
        tabs.setupWithViewPager(viewpager)


    }

    fun setupViewPager(vciewPager: ViewPager, manager: FragmentManager?)
    {
        var adapter :ViewPagerAdapterList = ViewPagerAdapterList(manager)
        adapter.addFragment(SimpleListFragment(), "simple list")
        adapter.addFragment(CustomListFragment(), "CustomList")
        vciewPager.adapter = adapter
    }


}
