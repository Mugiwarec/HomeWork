package ru.techpark.myhw2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.techpark.myhw2.R
import ru.techpark.myhw2.adapter.MyAdapter
import ru.techpark.myhw2.clicklistener.MyClickListener
import ru.techpark.myhw2.data.DataList
import ru.techpark.myhw2.data.DataSource

class RecyclerFragment : BaseFragment(), MyClickListener {

    private lateinit var mAdapter: MyAdapter
    private var dataSize: Int = DataList.getCounter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_listgrid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            dataSize = savedInstanceState.getInt("counterElements")
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.list)

        val button: Button = view.findViewById(R.id.button_add)
        button.setOnClickListener {
            DataList.addList()
            mAdapter!!.notifyDataSetChanged()
        }

        mAdapter = MyAdapter(DataList.getData(), this)
        var columns: Int = resources.getInteger(R.integer.counter_columns)

        recyclerView.layoutManager = GridLayoutManager(view.context, columns)
        recyclerView.adapter = mAdapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("counterElements", mAdapter!!.getDataList().size)
    }

    override fun onSoloClick(data: DataSource) {
        if (activity == null || activity !is MyClickListener) {
            return
        }

        (activity as MyClickListener).onSoloClick(data)
    }

    companion object {
        const val TAG = "RecyclerFragment"
    }

}