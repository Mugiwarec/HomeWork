package ru.techpark.myhw2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.techpark.myhw2.R
import ru.techpark.myhw2.data.DataSource

class SingleFragment : BaseFragment() {

    private var number: Int = 0
    private var color: Int = 0
    private lateinit var mTextView: TextView

    fun setNumber(data: DataSource) {
        val bundle: Bundle = Bundle()
        bundle.putInt("number", data.getNumber())
        bundle.putInt("color", data.getColor())
        arguments = bundle
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle: Bundle = arguments ?: return

        number = bundle.getInt("number")
        color = bundle.getInt("color")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_single, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTextView = view.findViewById(R.id.numberView)
        mTextView.text = number.toString()
        mTextView.setTextColor(color)
    }

    companion object {
        const val TAG = "SingleFragment"
    }

}