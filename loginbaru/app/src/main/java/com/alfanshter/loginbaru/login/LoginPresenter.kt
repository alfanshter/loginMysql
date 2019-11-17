package com.alfanshter.loginbaru.login

import android.content.Context
import com.alfanshter.loginbaru.Model.DataClass
import com.alfanshter.loginbaru.client.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter (val context : Context , val view : LoginView , val client : ApiClient)
{
    fun dologin(email : String , password : String)
    {
         client.login(email,password).enqueue(object : Callback<DataClass>
        {
            override fun onFailure(call: Call<DataClass>, t: Throwable) {
                view.showresponse("error${t.message}")
            }

            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                if (response.body()!=null)
                {
                    view.showresponse("${response.body()?.value}")
                    view.getdata(response.body()!!.resultData)
                }

            }

        }
        )
    }
}
