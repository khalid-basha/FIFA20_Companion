package com.fifa20companion.fifa20companion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fifa20companion.fifa20companion.modulers.Player

class SearchPlayerResult : AppCompatActivity(),CellClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_player_result)


        val recyclerview = findViewById<RecyclerView>(R.id.recycler)

        val data = intent.extras?.get("listPlayers") as Array<Player>

        recyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(data, this)
        recyclerview.adapter = adapter


     }

    override fun onCellClickListener(player: Player) {
        val intent = Intent(this@SearchPlayerResult, com.fifa20companion.fifa20companion.Player::class.java)
        intent.putExtra("dataPlayer", player)
        startActivity(intent)
    }
}