package com.fifa20companion.fifa20companion

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fifa20companion.fifa20companion.api.Player
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class ActivityChart : AppCompatActivity() {

    lateinit var barlist:ArrayList<BarEntry>
    lateinit var barDataSet: BarDataSet
    lateinit var barData: BarData
    var barChart: BarChart = findViewById(R.id.barChart)
    val player: Player = intent.extras?.get("dataPlayer") as Player
    lateinit var count:ArrayList<Int>


    /// get data from API


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
        barlist= ArrayList()
        if(player.overall !!>= 90)
            count[0]++
        else if(player.overall !!>= 80)
            count[1]++
        else if(player.overall !!>= 70)
            count[2]++
        else if(player.overall !!>= 60)
            count[3]++
        else if(player.overall !!>= 50)
            count[4]++
        else if(player.overall !!>= 40)
            count[5]++

        barlist.add(BarEntry(90f,count[0].toFloat()))
        barlist.add(BarEntry(80f,count[1].toFloat()))
        barlist.add(BarEntry(70f,count[2].toFloat()))
        barlist.add(BarEntry(60f,count[3].toFloat()))
        barlist.add(BarEntry(50f,count[4].toFloat()))
        barlist.add(BarEntry(40f,count[5].toFloat()))



        barDataSet = BarDataSet(barlist,"Players Distribution According to Overall")
        barData = BarData(barDataSet)
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS,250)
        barChart.data = barData

        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize=15f






    }
}