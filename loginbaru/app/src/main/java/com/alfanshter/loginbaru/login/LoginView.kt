package com.alfanshter.loginbaru.login

import com.alfanshter.loginbaru.Model.ResultItemData

interface LoginView {
    fun showloading()
    fun hideloading()
    fun showresponse(data:String)
    fun getdata(data: List<ResultItemData?>?)

}