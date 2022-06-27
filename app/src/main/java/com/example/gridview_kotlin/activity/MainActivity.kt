package com.example.gridview_kotlin.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.gridview_kotlin.R


class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        Log.d(TAG, "MainActivity onCreate")
    }

    /*override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MainActivity onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity onDestroy")
    }*/

    fun initViews() {
        val button = findViewById<Button>(R.id.b_push)
        button.setOnClickListener { openActivity() }
    }

    fun openActivity() {
        val intent = Intent(this, RuntimeActivity::class.java)
        startActivity(intent)
    }
}