package com.fifa20companion.fifa20companion


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.fifa20companion.fifa20companion.api.RetrofitServer
import com.fifa20companion.fifa20companion.modulers.SignUpBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        val email = findViewById<EditText>(R.id.emailSign)
        val pass = findViewById<EditText>(R.id.pass1Sign)
        val name = findViewById<EditText>(R.id.nameSign)
        val pass2 = findViewById<EditText>(R.id.pass2Sign)
        val sign = findViewById<Button>(R.id.SignUp)
        val logBtn = findViewById<TextView>(R.id.toLog)

        logBtn.setOnClickListener {
            val intent = Intent(this@Signup, Login::class.java)
            startActivity(intent)
        }

        sign.setOnClickListener {

            if (email.text.isNullOrEmpty()){
                Toast.makeText(
                    this@Signup,  "Please Add an E-Mail"
                    , Toast.LENGTH_SHORT
                ).show()
            }
            else if (name.text.isNullOrEmpty()){
                Toast.makeText(
                    this@Signup,  "Please Add a Name"
                    , Toast.LENGTH_SHORT
                ).show()

            }else if (pass.text.isNullOrEmpty()){
                Toast.makeText(
                    this@Signup,  "Please Add Password"
                    , Toast.LENGTH_SHORT
                ).show()

            }else if (pass2.text.isNullOrEmpty()){
                Toast.makeText(
                    this@Signup,  "Please Reset Password"
                    , Toast.LENGTH_SHORT
                ).show()
            }else{

                if (pass.text.toString().trim() ==pass2.text.toString().trim()) {
                    val req = SignUpBody(
                        name = name.text.toString().trim(),
                        email = email.text.toString().trim(),
                        password = pass.text.toString().trim()
                    )

                    RetrofitServer.getRetrofitApi()?.signup(req)?.enqueue(
                        object : Callback<Any> {
                            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                                if (response.isSuccessful) {

                                    if (response.body().toString() == "Invalid Email !"){
                                        Toast.makeText(
                                            this@Signup,  "Invalid Email"
                                            , Toast.LENGTH_SHORT
                                        ).show()

                                    }
                                    else{
                                        Toast.makeText(
                                            this@Signup,  "Account Create Successfully"
                                            , Toast.LENGTH_SHORT
                                        ).show()
                                        val intent = Intent(this@Signup, MainActivity2::class.java)
                                        startActivity(intent)


                                    }

                                } else {

                                    Toast.makeText(
                                        this@Signup, "Response Failed: " +
                                                response.body().toString(), Toast.LENGTH_SHORT
                                    ).show()
                                    print(response.body())

                                }
                            }

                            override fun onFailure(call: Call<Any>, t: Throwable) {
                                Toast.makeText(
                                    this@Signup, "Request Failed: " +
                                            call.toString(), Toast.LENGTH_SHORT
                                ).show()

                                println(call.request())
                            }
                        }

                    )
                }
                else{

                    Toast.makeText(
                        this@Signup,  "Passwords Mismatch"
                        , Toast.LENGTH_SHORT
                    ).show()

                }

            }







        }





}}