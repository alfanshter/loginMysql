package com.alfanshter.loginbaru.menu.menulist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfanshter.loginbaru.MainActivity
import com.alfanshter.loginbaru.Model.DataClass
import com.alfanshter.loginbaru.Model.ResultItemData

import com.alfanshter.loginbaru.R
import com.alfanshter.loginbaru.adaptor.RecyclerviewAdapter
import com.alfanshter.loginbaru.client.ApiClient
import com.alfanshter.loginbaru.client.ApiResponse
import com.alfanshter.loginbaru.gambar
import kotlinx.android.synthetic.main.fragment_reycle_view.*
import org.jetbrains.anko.support.v4.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class ReycleViewFragment : Fragment(),View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ab->{
                startActivity<gambar>()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reycle_view, container, false)
    }

    private lateinit var recyclerviewAdapter: RecyclerviewAdapter
    private var arrayList:ArrayList<ResultItemData> = arrayListOf()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ab.setOnClickListener(this)
        arrayList = arrayListOf()

        recyclerviewAdapter= RecyclerviewAdapter(context!!,arrayList){startActivity<MainActivity>()}
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter =recyclerviewAdapter
        jenis()
    }



    fun jenis ()
    {

        val client : ApiClient = ApiResponse().response()
        client.tampilall().enqueue(object : Callback<DataClass> {
            override fun onFailure(call: Call<DataClass>, t: Throwable) {

            }

            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
               arrayList.addAll(response.body()?.resultData as ArrayList<ResultItemData>)
                recyclerviewAdapter.notifyDataSetChanged()
            }

        })
    }

}
