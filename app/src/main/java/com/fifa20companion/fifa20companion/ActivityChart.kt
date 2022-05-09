package com.fifa20companion.fifa20companion

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fifa20companion.fifa20companion.R
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


    /// get data from API


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
        barlist= ArrayList()


        barDataSet = BarDataSet(barlist,"Players Distribution According to Overall")
        barData = BarData(barDataSet)
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS,250)
        barChart.data = barData

        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize=15f






    }
}