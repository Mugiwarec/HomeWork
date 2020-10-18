package ru.techpark.myhw2.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.techpark.myhw2.R
import ru.techpark.myhw2.clicklistener.MyClickListener
import ru.techpark.myhw2.data.DataList
import ru.techpark.myhw2.data.DataSource

class MyViewHolder(itemView: View, myClickListener: MyClickListener) :
    RecyclerView.ViewHolder(itemView) {

    var mTextView: TextView = itemView.findViewById(R.id.number)
        private set

    init {
        mTextView.setOnClickListener {
            val pos: Int = adapterPosition
            val data: DataSource = DataList.mData[pos]

            myClickListener.onSoloClick(data)
        }
    }

}