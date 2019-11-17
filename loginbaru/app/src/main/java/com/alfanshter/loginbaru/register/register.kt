package com.alfanshter.loginbaru.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alfanshter.loginbaru.R
import com.alfanshter.loginbaru.client.ApiResponse
import com.alfanshter.loginbaru.login.loginActivity
import com.alfanshter.loginbaru.session.SessionManager
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class register : AppCompatActivity(),RegisterView {
    override fun showloading() {

    }

    override fun hideloading() {

    }

    override fun showresponse(data: String) {
        toast(data)
        startActivity<loginActivity>()
    }
    private lateinit var presenter: RegisterPresenter

    private lateinit var session:SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        presenter = RegisterPresenter(applicationContext,this,ApiResponse().response())
        session = SessionManager(applicationContext)
        session.setlogin(false)
        register2.setOnClickListener {
            presenter.doRegister(username2.text.toString(), password2.text.toString())

        }
}

}
