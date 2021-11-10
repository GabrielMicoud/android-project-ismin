package com.ismin.android

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MonumentViewHolder(rootView: View): RecyclerView.ViewHolder(rootView) {

    var txvImm = rootView.findViewById<TextView>(R.id.r_monument_txv_imm)
    var txvDep = rootView.findViewById<TextView>(R.id.r_monument_txv_dep)
    var txvCom = rootView.findViewById<TextView>(R.id.r_monument_txv_com)
}
