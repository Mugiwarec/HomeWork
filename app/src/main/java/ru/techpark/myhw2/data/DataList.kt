package ru.techpark.myhw2.data

object DataList {

    private var counterNumbers = 100
    private val mData: MutableList<DataSource> = (1..100).map { DataSource(it) }.toMutableList()

    fun getCounter(): Int = counterNumbers

    fun getData(): MutableList<DataSource> = mData

    fun addList() {
        counterNumbers++
        mData.add(DataSource(counterNumbers))
    }

}