package com.fifa20companion.fifa20companion

import com.fifa20companion.fifa20companion.api.Player
import com.fifa20companion.fifa20companion.api.RetrofitServer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.*


fun main() {
//    RetrofitServer.getAllPlayers().enqueue(object:Callback<Player>{
//        override fun onResponse(call: Call<Player>, response: Response<Player>) {
//            if (call.isExecuted) {
//                var p = response.body() as Player
//                print(p.name)
//            }
//
//        }
//
//        override fun onFailure(call: Call<Player>, t: Throwable) {
//           println(t.message)
//        }
//
//
//    })

    val url = URL("https://api.jsonserve.com/uXfvKO/")
    val connection = url.openConnection()
    BufferedReader(InputStreamReader(connection.getInputStream())).use { inp ->
        var line: String?=""
        while (inp.readLine().also { line = it } != null) {
            println(line)
        }
    }

    return
}
