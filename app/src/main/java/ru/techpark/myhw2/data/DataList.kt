package ru.techpark.myhw2.data

object DataList {

    var mData: MutableList<DataSource> = mutableListOf()
        private set

    fun addList() {
        mData.add(DataSource(mData.size + 1))
    }

    fun resizeTo(newSize: Int) {
        if (mData.size != newSize)
            mData.addAll((mData.size + 1..newSize).map { DataSource(it) }.toMutableList())
    }

}