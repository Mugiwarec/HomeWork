package ru.techpark.myhw2.data

object DataList {

    var sizeList = 100
        private set

    var mData: MutableList<DataSource> = (1..sizeList).map { DataSource(it) }.toMutableList()
        private set

    fun addList() {
        sizeList++
        mData.add(DataSource(sizeList))
    }

    fun resizeTo(newSize: Int) {
        if (mData.size != newSize) {
            mData.addAll((sizeList + 1..newSize).map { DataSource(it) }.toMutableList())

            sizeList = newSize
        }
    }

}