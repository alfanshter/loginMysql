package com.alfanshter.loginbaru.menu.menuberanda


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alfanshter.loginbaru.Model.DataClass
import com.alfanshter.loginbaru.Model.ResultItemData

import com.alfanshter.loginbaru.R
import com.alfanshter.loginbaru.adaptor.AdapterTabelBarang
import com.alfanshter.loginbaru.client.ApiClient
import com.alfanshter.loginbaru.client.ApiResponse
import com.alfanshter.loginbaru.session.SessionManager
import kotlinx.android.synthetic.main.fragment_kategori.*
import org.jetbrains.anko.support.v4.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Kategori : Fragment() {
    private lateinit var adapter:AdapterTabelBarang
    private lateinit var session: SessionManager
    private var datajenis : ArrayList<ResultItemData?>?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datajenis = arrayListOf()
        adapter = AdapterTabelBarang(datajenis)
        listnamajenis.adapter = adapter

        session = SessionManager(context!!)
        jenis()


        btn_insert.setOnClickListener {
            val model = listnamajenis.selectedItem as ResultItemData
            toast(model.namajenis.toString())
            val client : ApiClient = ApiResponse().response()
            client.insertbarang(nama.text.toString(),quantity.text.toString(),harga.text.toString(),model.namajenis.toString()).enqueue(object : Callback<DataClass> {
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
        return inflater.inflate(R.layout.fragment_kategori, container, false)
    }


}
