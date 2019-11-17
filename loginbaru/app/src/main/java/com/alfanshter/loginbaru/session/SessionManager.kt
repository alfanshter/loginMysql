package com.alfanshter.loginbaru.session

import android.content.Context
import android.content.SharedPreferences


class SessionManager(val contexts: Context){
//untuk memanggil id
    val PrivateMode = 0
    val PrivateName = "login"
    var Pref: SharedPreferences?=contexts.getSharedPreferences(PrivateName,PrivateMode)
    var editor : SharedPreferences.Editor?=Pref?.edit()

    private val islogin = "login"
    fun setlogin(check:Boolean)
    {
        editor?.putBoolean(islogin,check)
        editor?.commit()
    }

    fun getlogin():Boolean?
    {
        return Pref?.getBoolean(islogin,false)
    }


    private val iduser = "iduser"
    fun setiduser(check:String)
    {
        editor?.putString(iduser,check)
        editor?.commit()
    }

    fun getiduser():String?
    {
        return Pref?.getString(iduser,"")
    }




}