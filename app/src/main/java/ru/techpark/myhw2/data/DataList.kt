package ru.techpark.myhw2.data

object DataList {

    private var counterNumbers = 100
    private val mData: MutableList<DataSource> =
        mutableListOf(elements = Array(size = counterNumbers) { i: Int -> DataSource(i + 1) })

    fun getCounter(): Int {
        return counterNumbers
    }

    fun getData(): MutableList<DataSource> {
        return mData
    }

    fun addList() {
        counterNumbers++
        mData.add(DataSource(counterNumbers))
    }

}