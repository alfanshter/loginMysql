package com.alfanshter.loginbaru

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.alfanshter.loginbaru.login.loginActivity
import com.alfanshter.loginbaru.menu.menuberanda.Beranda
import com.alfanshter.loginbaru.menu.BerandaFragment
import com.alfanshter.loginbaru.menu.menuberanda.Kategori
import com.alfanshter.loginbaru.menu.ListFragment
import com.alfanshter.loginbaru.menu.menulist.ReycleViewFragment
import com.alfanshter.loginbaru.session.SessionManager
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private lateinit var session:SessionManager

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame,BerandaFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame,
                    Kategori()
                ).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame,ListFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profil -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame,ReycleViewFragment()).commit()
                return@OnNavigationItemSelectedListener  true
                /*finish()
                if (session.getlogin()!!){
                    session.setlogin(false)
                    startActivity<loginActivity>()
                    finish()
                }*/

            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        session = SessionManager(applicationContext)

        supportFragmentManager.beginTransaction().replace(R.id.frame,
            Beranda()
        ).commit()

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
