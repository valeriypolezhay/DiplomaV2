package com.example.diploma.khaiid

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_sign_up -> {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
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

    }


    fun fetchJson() {
        println("Attempting to fetch json")

//        val url = "https://my-json-server.typicode.com/valeriypolezhay/DiplomaV2/users"
        val url = "https://my-json-server.typicode.com/valeriypolezhay/DiplomaV2/users"

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.toString()
                println(body)

                val gson = GsonBuilder().create()

                val usersFeed = gson.fromJson(body, User::class.java)
//                val usersFeed = gson.fromJson(body, UsersFeed::class.java)


                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(usersFeed)
//                    recyclerView_main.adapter = MainAdapter(users)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })
    }

}

//class UsersFeed(val users: Array<User>)
