package com.alfanshter.loginbaru.menu.menuberanda


import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alfanshter.loginbaru.Model.DataClass
import com.alfanshter.loginbaru.Model.ResultItemData

import com.alfanshter.loginbaru.R
import com.alfanshter.loginbaru.adaptor.AdapterTabelBarang
import com.alfanshter.loginbaru.client.ApiClient
import com.alfanshter.loginbaru.client.ApiResponse
import com.alfanshter.loginbaru.session.SessionManager
import kotlinx.android.synthetic.main.fragment_beranda.*
import kotlinx.android.synthetic.main.fragment_kategori.*
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */

class Beranda : Fragment() {
    private lateinit var session: SessionManager
    private var datajenis : ArrayList<ResultItemData?>?=null
    private lateinit var adapter:AdapterTabelBarang


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        session = SessionManager(context!!)
        toast(session.getiduser()!!)   //menampilkan  id USER

        val client : ApiClient = ApiResponse().response()
        datajenis = arrayListOf()
        adapter = AdapterTabelBarang(datajenis)
        hasil.adapter = adapter

        jenis()
        insert.setOnClickListener {

                client.jenisbarang(jenis.text.toString(),session.getiduser()!!).enqueue(object :Callback <DataClass>{
                    override fun onFailure(call: Call<DataClass>, t: Throwable) {
                        toast("gagal koneksi")
                    }

                    override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                        toast("berhasil insert")
                    }
                } )

            }


    }

    fun jenis ()
    {

        val client : ApiClient = ApiResponse().response()
        client.tampiltbjenis(session.getiduser()!!).enqueue(object : Callback<DataClass>{
            override fun onFailure(call: Call<DataClass>, t: Throwable) {

            }

            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                datajenis?.addAll(response.body()?.resultData!!)
                adapter.notifyDataSetChanged()
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }


}


