package ru.techpark.myhw2.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.techpark.myhw2.R
import ru.techpark.myhw2.adapter.MyAdapter
import ru.techpark.myhw2.clicklistener.MyClickListener
import ru.techpark.myhw2.data.DataList
import ru.techpark.myhw2.data.DataSource

class RecyclerFragment : Fragment(), MyClickListener {

    private lateinit var mAdapter: MyAdapter
    private lateinit var listener: MyClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as MyClickListener
        mAdapter = MyAdapter(DataList.mData, listener)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_listgrid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.list)

        val button: Button = view.findViewById(R.id.button_add)
        button.setOnClickListener {
            DataList.addList()
            mAdapter.notifyItemChanged(DataList.mData.size)
        }

        val columns: Int = resources.getInteger(R.integer.counter_columns)

        recyclerView.layoutManager = GridLayoutManager(view.context, columns)
        recyclerView.adapter = mAdapter
    }

    override fun onSoloClick(data: DataSource) {
        listener.onSoloClick(data)
    }

    companion object {
        const val TAG = "RecyclerFragment"
    }

}