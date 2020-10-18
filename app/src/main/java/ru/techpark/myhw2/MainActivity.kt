package ru.techpark.myhw2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.techpark.myhw2.clicklistener.MyClickListener
import ru.techpark.myhw2.data.DataSource
import ru.techpark.myhw2.fragment.RecyclerFragment
import ru.techpark.myhw2.fragment.SingleFragment

class MainActivity : AppCompatActivity(), MyClickListener {

    private var recyclerFragment: RecyclerFragment? = null
    private var singleFragment: SingleFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerFragment = supportFragmentManager.findFragmentByTag(RecyclerFragment.TAG) as RecyclerFragment?
        singleFragment = supportFragmentManager.findFragmentByTag(SingleFragment.TAG) as SingleFragment?

        if (recyclerFragment == null) {
            recyclerFragment = RecyclerFragment()
        }

        if (singleFragment == null) {
            singleFragment = SingleFragment()
        }

        showRecyclerView()
    }

    private fun showRecyclerView() {
        if (supportFragmentManager.findFragmentByTag(RecyclerFragment.TAG) != null) {
            return
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.content, recyclerFragment!!, RecyclerFragment.TAG)
            .commit()
    }

    private fun showSingleView(data: DataSource) {
        if (supportFragmentManager.findFragmentByTag(SingleFragment.TAG) != null) {
            Log.wtf(MainActivity::class.java.toString(), "SingleFragment execute twice")
            return
        }

        singleFragment!!.setNumber(data)

        supportFragmentManager.beginTransaction()
            .replace(R.id.content, singleFragment!!, SingleFragment.TAG)
            .addToBackStack(SingleFragment.TAG)
            .commit()
    }

    override fun onSoloClick(data: DataSource) {
        showSingleView(data)
    }

}