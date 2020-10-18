package ru.techpark.myhw2.data

import android.graphics.Color

class DataSource constructor(mNumber: Int) {

    var mNumber: Int = mNumber
        private set

    var mColor = if (mNumber % 2 == 0) Color.RED else Color.BLUE
        private set

}