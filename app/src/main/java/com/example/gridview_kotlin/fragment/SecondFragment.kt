package com.example.gridview_kotlin.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gridview_kotlin.R


class SecondFragment : Fragment() {
    private var listener: SecondListener? = null
    private var tv_second: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_second, container, false)
        tv_second = view.findViewById(R.id.tv_second)
        val b_second = view.findViewById<Button>(R.id.b_second)
        b_second?.setOnClickListener { listener!!.onSecondSend("PDP") }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is SecondListener) {
            context
        } else {
            throw RuntimeException(context.toString() + "must implement SecondListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun onSecondSend(str: String?) {
        tv_second!!.text = str
    }

    interface SecondListener {
        fun onSecondSend(str: String?)
    }
}