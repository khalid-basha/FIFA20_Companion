package com.fifa20companion.fifa20companion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

import com.fifa20companion.fifa20companion.api.Player
import com.fifa20companion.fifa20companion.api.RetrofitServer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFilters : AppCompatActivity() {
    lateinit var search:View

  //  lateinit var subName: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_filters)
        search=findViewById(R.id.searchBtn)
        val subName=findViewById<EditText>(R.id.name)
        val spinner =findViewById<Spinner>(R.id.spinner)
        val overallMin=findViewById<EditText>(R.id.overallMinValue)
        val overallMax =findViewById<EditText>(R.id.overallMaxValue)
        val ageMin=findViewById<EditText>(R.id.ageMinValue)
        val ageMax=findViewById<EditText>(R.id.ageMaxValue)


        var role=""

        if (spinner != null) {
            val allOptions= Position.values()

            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, allOptions)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {

                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    role = if (position==0)
                        ""
                    else
                        allOptions[position].toString()
                   /* Toast.makeText(this@SearchFilters,
                         role, Toast.LENGTH_SHORT).show()*/
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        
        search.setOnClickListener {

            var min0= when(overallMin.text.toString()) {
                "" -> 0
                else ->overallMin.text.toString().toInt()
            }
            var min1= when(ageMin.text.toString()) {
                "" -> 0
                else ->ageMin.text.toString().toInt()
            }
            var max0= when(overallMax.text.toString()) {
                "" -> 99
                else ->overallMax.text.toString().toInt()
            }
            var max1= when(ageMax.text.toString()) {
                "" -> 99
                else ->ageMax.text.toString().toInt()
            }

            RetrofitServer.getRetrofitApi()?.getAllPlayers(
                name = subName.text.toString(),
                overallMin =min0 ,
                overallMax = max0,
                ageMin = min1 ,
                ageMax =max1,
                position = role
            )?.enqueue(object : Callback<Array<Player>>{

                override fun onResponse(
                    call: Call<Array<Player>>,
                    response: Response<Array<Player>>
                ) {
                    if(call.isExecuted){
                        if(response.isSuccessful)
                        {
                            val intent = Intent(this@SearchFilters, SearchPlayerResult::class.java)
                            intent.putExtra("listPlayers", response.body()?.toList()?.take(300)
                                ?.toTypedArray() as Array<Player>)

                           startActivity(intent)


                        }else{
                            Toast.makeText(this@SearchFilters,"response error :"+
                                response.body().toString(), Toast.LENGTH_SHORT).show()

                        }

                    }
                    else{
                        Toast.makeText(this@SearchFilters,"call error: " +
                            call.toString(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Array<Player>>, t: Throwable) {
                    Toast.makeText(this@SearchFilters,
                        t.message, Toast.LENGTH_SHORT).show()
                }
            })


        }
    }


}