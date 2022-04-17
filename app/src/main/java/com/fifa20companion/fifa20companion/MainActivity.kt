package com.fifa20companion.fifa20companion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainlogin = findViewById<Button>(R.id.login)

        mainlogin.setOnClickListener(){

            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)

        }

        val mainsignup = findViewById<Button>(R.id.Signup)
        mainsignup.setOnClickListener(){

            val intent = Intent(this@MainActivity, Signup::class.java)
            startActivity(intent)

        }
    }


}