package ru.techpark.myhw2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.techpark.myhw2.R
import ru.techpark.myhw2.data.DataSource

class SingleFragment() : Fragment() {

    private var number: Int = 0
    private var color: Int = 0
    private lateinit var mTextView: TextView

    constructor(data: DataSource) : this() {
        number = data.getNumber()
        color = data.getColor()
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

        savedInstanceState?.let {
            number = savedInstanceState.getInt("number")
            color = savedInstanceState.getInt("color")
        }

        mTextView = view.findViewById(R.id.numberView)
        mTextView.text = number.toString()
        mTextView.setTextColor(color)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("number", number)
        outState.putInt("color", color)
    }

    companion object {
        const val TAG = "SingleFragment"
    }

}