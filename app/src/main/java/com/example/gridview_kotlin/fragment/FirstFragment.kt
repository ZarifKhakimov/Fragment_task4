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


class FirstFragment : Fragment() {
    private var listener: FirstListener? = null
    var tv_first: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)
        tv_first = view.findViewById(R.id.tv_first)
        val b_first = view.findViewById<Button>(R.id.b_first)
        b_first?.setOnClickListener { listener!!.onFirstSend("Academy") }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is FirstListener) {
            context
        } else {
            throw RuntimeException(context.toString() + "must implement FirstListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun onFirstSend(str: String?) {
        tv_first!!.text = str
    }

    interface FirstListener {
        fun onFirstSend(str: String?)
    }
}

