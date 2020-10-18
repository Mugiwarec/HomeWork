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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerFragment =
            supportFragmentManager.findFragmentByTag(RecyclerFragment.TAG) as RecyclerFragment?

        if (recyclerFragment == null)
            recyclerFragment = RecyclerFragment()

        showRecyclerView()
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