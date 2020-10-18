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

    private val mTextView: TextView = itemView.findViewById(R.id.number)

    init {
        mTextView.setOnClickListener {
            val pos: Int = adapterPosition
            val data: DataSource = DataList.getData()[pos]

            myClickListener.onSoloClick(data)
        }
    }

    fun getText(): TextView {
        return mTextView
    }

}