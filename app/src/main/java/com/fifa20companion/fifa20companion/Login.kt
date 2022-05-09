package com.fifa20companion.fifa20companion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.fifa20companion.fifa20companion.api.RetrofitServer
import com.fifa20companion.fifa20companion.modulers.LogInBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val email = findViewById<EditText>(R.id.logEmail)
        val pass = findViewById<EditText>(R.id.pass)
        val logBtn = findViewById<Button>(R.id.logIn)
        val sign = findViewById<TextView>(R.id.toSign)

        sign.setOnClickListener {
            val intent = Intent(this@Login, Signup::class.java)
            startActivity(intent)

        }

        logBtn.setOnClickListener {
            if (email.text.isNotEmpty()) {
                if (pass.text.isNotEmpty()) {

                    val req = LogInBody(
                        email = email.text.toString().trim(),
                        password = pass.text.toString().trim()
                    )


                    RetrofitServer.getRetrofitApi()?.login(req)?.enqueue(
                        object : Callback<Any> {
                            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                                if (response.isSuccessful) {

                                    if (response.body().toString() == "Email or password is incorrect"){
                                        Toast.makeText(
                                            this@Login,  "Email or password is incorrect"
                                            , Toast.LENGTH_SHORT
                                        ).show()

                                    }
                                    else{
                                        Toast.makeText(
                                            this@Login,  "LogIn Successful"
                                            , Toast.LENGTH_SHORT
                                        ).show()
                                        val intent = Intent(this@Login, MainActivity2::class.java)
                                        startActivity(intent)


                                    }

                                } else {

                                    Toast.makeText(
                                        this@Login, "Response Failed: " +
                                                response.body().toString(), Toast.LENGTH_SHORT
                                    ).show()

                                }


                            }

                            override fun onFailure(call: Call<Any>, t: Throwable) {
                                Toast.makeText(
                                    this@Login, "Request Failed: " +
                                            call.toString(), Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    )

                } else
                    Toast.makeText(
                        this@Login,  "Please Add Password"
                        , Toast.LENGTH_SHORT
                    ).show()


            } else
                Toast.makeText(
                    this@Login,  "Please Add E-Mail"
                    , Toast.LENGTH_SHORT
                ).show()

        }
    }
}