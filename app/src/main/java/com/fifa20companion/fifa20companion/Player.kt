package com.fifa20companion.fifa20companion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.fifa20companion.fifa20companion.modulers.Player

class Player : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        val player: Player = intent.extras?.get("dataPlayer") as Player

        val name: TextView =findViewById(R.id.firstname)
        val overall: TextView =findViewById(R.id.ovrallval)
        val age: TextView =findViewById(R.id.ageval)
        val club: TextView =findViewById(R.id.clubVal)
        val nation: TextView =findViewById(R.id.nationalityval)
        val role: TextView =findViewById(R.id.posval)
        val weight: TextView =findViewById(R.id.weightval)
        val height: TextView =findViewById(R.id.heightval)
        val price: TextView =findViewById(R.id.priceval)
        val foot: TextView =findViewById(R.id.prefval)




        name.text =player.sName
        overall.text =player.overall.toString()
        age.text =player.age.toString()
        club.text =player.club
        nation.text =player.nation
        role.text =player.position.toString().trim()
        weight.text =player.weight.toString()
        height.text =player.height.toString()
        price.text =player.price.toString()
        foot.text =player.foot


    }
}