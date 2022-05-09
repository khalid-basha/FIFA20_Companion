package com.fifa20companion.fifa20companion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.fifa20companion.fifa20companion.api.Player
import com.fifa20companion.fifa20companion.api.RetrofitServer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val cardSearch:CardView =findViewById(R.id.cardSearch)
        val cardShowPlayers:CardView =findViewById(R.id.cardShowPlayers)
        val cardShowCharts:CardView =findViewById(R.id.chartsCard)

        cardSearch.setOnClickListener{
            val intent = Intent(this@MainActivity2, SearchFilters::class.java)
            startActivity(intent)
        }


        cardShowPlayers.setOnClickListener{
            RetrofitServer.getRetrofitApi()?.getAllPlayers(
                name = "",
                overallMin =0 ,
                overallMax = 99,
                ageMin = 0 ,
                ageMax =99,
                position = ""
            )?.enqueue(object : Callback<Array<Player>> {

                override fun onResponse(
                    call: Call<Array<Player>>,
                    response: Response<Array<Player>>
                ) {
                    if(call.isExecuted){
                        if(response.isSuccessful)
                        {
                            val intent = Intent(this@MainActivity2, SearchPlayerResult::class.java)
                            intent.putExtra("listPlayers", response.body()?.toList()?.take(400)
                                ?.toTypedArray() as Array<Player>)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this@MainActivity2,"response error :"+
                                    response.body().toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                    else{
                        Toast.makeText(this@MainActivity2,"call error: " +
                                call.toString(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Array<Player>>, t: Throwable) {
                    Toast.makeText(this@MainActivity2,
                        t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }


    }
}