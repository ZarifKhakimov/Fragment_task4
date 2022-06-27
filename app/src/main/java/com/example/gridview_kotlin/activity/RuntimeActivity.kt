package com.example.gridview_kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gridview_kotlin.R
import com.example.gridview_kotlin.fragment.FirstFragment
import com.example.gridview_kotlin.fragment.SecondFragment


class RuntimeActivity : AppCompatActivity(), FirstFragment.FirstListener,
    SecondFragment.SecondListener {
    var firstFragment: FirstFragment? = null
    var secondFragment: SecondFragment? = null

    /**/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runtime)
        initViews()
    }

    override fun onFirstSend(str: String?) {
        secondFragment?.onSecondSend(str)
    }

    override fun onSecondSend(str: String?) {
        firstFragment?.onFirstSend(str)
    }

    fun initViews() {
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frameFirst, firstFragment!!)
            .replace(R.id.frameSecond, secondFragment!!).commit()
    }
}