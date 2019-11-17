package com.alfanshter.loginbaru.register

import android.content.Context
import com.alfanshter.loginbaru.Model.DataClass
import com.alfanshter.loginbaru.client.ApiClient
import retrofit2.Call
import retrofit2.Response

class RegisterPresenter(val context: Context, val view: RegisterView, val client: ApiClient) {

    fun doRegister(email : String , password : String)
    {
        client.registerUser(email,password).enqueue(object :
            retrofit2.Callback<DataClass> {
            override fun onFailure(call: Call<DataClass>, t: Throwable) {
               view.showresponse("error${t.message}")
            }

            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
               view.showresponse("${response.body()?.value}")
            }

        })
    }
}