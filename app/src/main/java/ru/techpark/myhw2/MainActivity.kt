package ru.techpark.myhw2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.techpark.myhw2.clicklistener.MyClickListener
import ru.techpark.myhw2.data.DataList
import ru.techpark.myhw2.data.DataSource
import ru.techpark.myhw2.fragment.RecyclerFragment
import ru.techpark.myhw2.fragment.SingleFragment

class MainActivity : AppCompatActivity(), MyClickListener {

    private var recyclerFragment: RecyclerFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerFragment =
            supportFragmentManager.findFragmentByTag(RecyclerFragment.TAG) as RecyclerFragment?

        if (recyclerFragment == null)
            recyclerFragment = RecyclerFragment()

        showRecyclerView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("counterNumbers", DataList.counterNumbers)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val counterNumber = savedInstanceState.getInt("counterNumbers")
        if (counterNumber != 0) {
            DataList.restoreList(counterNumber)
        }
    }

    private fun showRecyclerView() {
        supportFragmentManager.findFragmentByTag(RecyclerFragment.TAG)?.let {
            return
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.content, recyclerFragment!!, RecyclerFragment.TAG)
            .commit()
    }

    private fun showSingleView(singleFragment: SingleFragment) {
        supportFragmentManager.findFragmentByTag(SingleFragment.TAG)?.let {
            Log.wtf(MainActivity::class.java.toString(), "SingleFragment execute twice")
            return
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.content, singleFragment, SingleFragment.TAG)
            .addToBackStack(SingleFragment.TAG)
            .commit()
    }

    override fun onSoloClick(data: DataSource) {
        val singleFragment = SingleFragment(data)
        showSingleView(singleFragment)
    }

}