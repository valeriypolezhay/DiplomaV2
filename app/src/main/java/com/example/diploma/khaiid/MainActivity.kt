package com.example.diploma.khaiid

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
//import com.example.diploma.khaiid.R.id.recyclerView_main
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.users_recycler.recyclerView_main
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val intent1 = Intent(this, MainActivity::class.java)
                startActivity(intent1)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_sign_up -> {
//                val intent2 = Intent(this, SignUpMenuActivity::class.java)
//                startActivity(intent2)
                changeFragment(Fragment())

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {


                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        recyclerView_main.layoutManager = LinearLayoutManager(this)
        fetchJson()

        changeFragment(Fragment())
    }

    private fun changeFragment(newFragment:Fragment){
        val ft=fragmentManager.beginTransaction()
        ft.replace(R.id.fragments, newFragment)
        ft.commit()
    }

    fun fetchJson() {
        println("Attempting to fetch json")

        val url = "https://my-json-server.typicode.com/valeriypolezhay/DiplomaV2/users"

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()
                val usersFeed = gson.fromJson(body, Array<User>::class.java)

                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(usersFeed)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })
    }

}
