package com.fifa20companion.fifa20companion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLogin = findViewById<Button>(R.id.login)

        mainLogin.setOnClickListener(){

            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)

        }

        val mainSignup = findViewById<Button>(R.id.Signup)
        mainSignup.setOnClickListener(){

            val intent = Intent(this@MainActivity, Signup::class.java)
            startActivity(intent)

        }
    }


}