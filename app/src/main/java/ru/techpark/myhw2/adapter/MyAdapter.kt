package ru.techpark.myhw2.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.techpark.myhw2.R
import ru.techpark.myhw2.clicklistener.MyClickListener
import ru.techpark.myhw2.data.DataSource

class MyAdapter(data: MutableList<DataSource>, listener: MyClickListener) :
    RecyclerView.Adapter<MyViewHolder>() {

    private val mListener: MyClickListener = listener
    private val mData: MutableList<DataSource> = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_for_list, parent, false)

        return MyViewHolder(v, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data: DataSource = mData[position]

        holder.getText().text = data.getNumber().toString()
        holder.getText().setTextColor(data.getColor())
        holder.getText().setBackgroundColor(Color.GRAY)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun getDataList(): List<DataSource> {
        return mData
    }

}