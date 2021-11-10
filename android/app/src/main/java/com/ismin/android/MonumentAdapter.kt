package com.ismin.android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MonumentAdapter(private val monuments: ArrayList<Monument>): RecyclerView.Adapter<MonumentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonumentViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_monument, parent, false)
        return MonumentViewHolder(row)
    }

    override fun onBindViewHolder(holder: MonumentViewHolder, position: Int) {
        val (imm, dep, com) = monuments[position]

        holder.txvImm.text = imm
        holder.txvDep.text = dep
        holder.txvCom.text = com
    }

    override fun getItemCount(): Int {
        return monuments.size
    }

    fun refreshData(newMonuments: ArrayList<Monument>) {
        monuments.clear()
        monuments.addAll(newMonuments)
    }
}
