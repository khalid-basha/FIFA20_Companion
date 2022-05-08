package com.fifa20companion.fifa20companion

import com.fifa20companion.fifa20companion.modulers.Player
import com.fifa20companion.fifa20companion.api.RetrofitServer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


fun main() {


   RetrofitServer.getRetrofitApi()?.getPlayer()?.enqueue(object :Callback<Player>{

        override fun onResponse(call: Call<Player>, response: Response<Player>) {
           if(call.isExecuted ){
               response.isSuccessful
               response.body()


           }

           println(response)
        }

        override fun onFailure(call: Call<Player>, t: Throwable) {
            println(t.message)
        }

    })

    /*RetrofitServer.getRetrofitApi()?.getAllPlayers()?.enqueue(object : Callback<List<Player>> {
        override fun onResponse(call: Call<List<Player>>, response: Response<List<Player>>) {
            if (call.isExecuted) {
                //for ( i in response.raw())
                val p: List<Player>? = response.body()
                // for (i in p)
                if (p != null) {
                    for (i in p)
                    println(i.name)
                }
                // print(response.body()?.name)
            }

        }

        override fun onFailure(call: Call<List<Player>>, t: Throwable) {
            println(t.toString())
            print("sdfnjfkdg")
        }
    })*/
/*
    val url = URL("https://api.jsonserve.com/uXfvKO/")
    val connection = url.openConnection()
    BufferedReader(InputStreamReader(connection.getInputStream())).use { inp ->
        var line: String?=""
        while (inp.readLine().also { line = it } != null) {
            println(line)
        }
    }
*/

    return
}
