package ru.techpark.myhw2.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(getLogTag(), "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(getLogTag(), "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(getLogTag(), "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(getLogTag(), "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(getLogTag(), "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(getLogTag(), "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(getLogTag(), "onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d(getLogTag(), "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(getLogTag(), "onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(getLogTag(), "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(getLogTag(), "onDetach")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(getLogTag(), "onSaveInstanceState")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(getLogTag(), "onViewStateRestored")
    }

    protected open fun getLogTag(): String? {
        return javaClass.simpleName
    }

}