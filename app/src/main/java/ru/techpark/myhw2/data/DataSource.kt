package ru.techpark.myhw2.data

import android.graphics.Color

class DataSource constructor(mNumber: Int) {

    private val mNumber: Int = mNumber
    private val mColor = if (mNumber % 2 == 0) Color.RED else Color.BLUE

    fun getNumber(): Int {
        return mNumber
    }

    fun getColor(): Int {
        return mColor
    }

}