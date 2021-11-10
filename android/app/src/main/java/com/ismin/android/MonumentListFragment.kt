package com.ismin.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_MONUMENTS = "monuments"

class MonumentListFragment : Fragment() {
    private lateinit var monuments: ArrayList<Monument>
    private lateinit var adapter : MonumentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val argMonuments = requireArguments().getSerializable(ARG_MONUMENTS) as ArrayList<Monument>?
        monuments = argMonuments ?: ArrayList()
        adapter = MonumentAdapter(monuments, this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_monument_list, container, false)

        val rcvMonuments = view.findViewById<RecyclerView>(R.id.f_monument_list_rcv_monuments)
        rcvMonuments.layoutManager = LinearLayoutManager(context)
        rcvMonuments.adapter = adapter

        return view;
    }

    companion object {
        @JvmStatic
        fun newInstance(monuments: ArrayList<Monument>) =
            MonumentListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_MONUMENTS, monuments)
                }
            }
    }
}