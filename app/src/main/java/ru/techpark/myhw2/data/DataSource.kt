package ru.techpark.myhw2.data

import android.graphics.Color

class DataSource constructor(private val mNumber: Int) {

    private val mColor = if (mNumber % 2 == 0) Color.RED else Color.BLUE

    fun getNumber(): Int = mNumber

    fun getColor(): Int = mColor

}