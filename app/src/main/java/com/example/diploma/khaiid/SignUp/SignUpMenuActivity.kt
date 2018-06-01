package com.example.diploma.khaiid.SignUp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.diploma.khaiid.R


class SignUpMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_menu_activity)

        var button2=findViewById<Button>(R.id.button2)
        var button3=findViewById<Button>(R.id.button3)
        var button4=findViewById<Button>(R.id.button4)


        button2.setOnClickListener{
            val intent1 = Intent(this, SignUpStudentActivity::class.java)
            startActivity(intent1)
        }
        button3.setOnClickListener{
            val intent2 = Intent(this, SignUpTeacherActivity::class.java)
            startActivity(intent2)
        }

        button4.setOnClickListener{
            val intent3 = Intent(this, SignUpCourseActivity::class.java)
            startActivity(intent3)
        }

    }
}