package ru.techpark.myhw2.data

object DataList {

    var counterNumbers = 100
        private set

    var mData: MutableList<DataSource> = (1..counterNumbers).map { DataSource(it) }.toMutableList()
        private set

    fun addList() {
        counterNumbers++
        mData.add(DataSource(counterNumbers))
    }

    fun restoreList(value: Int) {
        if (mData.size != value) {
            mData.addAll((counterNumbers + 1..value).map { DataSource(it) }.toMutableList())

            counterNumbers = value
        }
    }

}