package com.fifa20companion.fifa20companion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.fifa20companion.fifa20companion.modulers.Player

class Adapter(private val mList: Array<Player>, private val cellClickListener: CellClickListener) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.player_card, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {

        val player = mList[position]
        holder.name.text = player.sName?.trim()
        holder.overall.text = player.overall.toString()
        holder.age.text = player.age.toString()
        holder.club.text = player.club
        holder.nation.text = player.nation
        holder.role.text = player.position.toString().trim().split(',')[0]
        holder.card.setOnClickListener {

            cellClickListener.onCellClickListener(player)

        }

    }




    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder (ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val name: TextView =ItemView.findViewById(R.id.nameRes)
        val overall: TextView =ItemView.findViewById(R.id.overallRes)
        val age: TextView =ItemView.findViewById(R.id.ageRes)
        val club: TextView =ItemView.findViewById(R.id.clubRes)
        val nation: TextView =ItemView.findViewById(R.id.natRes)
        val role: TextView =ItemView.findViewById(R.id.roleRes)
        val card: ConstraintLayout =ItemView.findViewById(R.id.card)

    }
}