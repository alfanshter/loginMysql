package com.alfanshter.loginbaru.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alfanshter.loginbaru.login.LoginView
import com.alfanshter.loginbaru.MainActivity
import com.alfanshter.loginbaru.Model.ResultItemData
import com.alfanshter.loginbaru.R
import com.alfanshter.loginbaru.client.ApiResponse
import com.alfanshter.loginbaru.register.register
import com.alfanshter.loginbaru.session.SessionManager
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class loginActivity : AppCompatActivity(), LoginView {

    override fun getdata(data: List<ResultItemData?>?) {
        if (data?.size!! >0)
        {
            session.setlogin(true)     //mengubah nilai login jadi true
            session.setiduser(data[0]?.iduser.toString())    // array 0 pada iduser
            startActivity<MainActivity>()
            finish()
        }
    }

    override fun showloading() {

    }

    override fun hideloading() {

    }

    override fun showresponse(data: String) {
        if (data.equals("0"))
        {
            toast("error")
        }
    }

    private lateinit var session:SessionManager

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        session = SessionManager(applicationContext)
        presenter = LoginPresenter(applicationContext,this , ApiResponse().response())

        if (session.getlogin()!!){
            startActivity<MainActivity>()
            finish()
        }

        login.setOnClickListener {
            presenter.dologin(username.text.toString(),password.text.toString())
        }

        btn_register.setOnClickListener {

            startActivity<register>()
        }

    }
}
