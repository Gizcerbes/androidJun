package com.uogames.androidjun

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class MyRecyclerAdapter : RecyclerView.Adapter<MyRecyclerAdapter.MyHolder>() {

    val list = ArrayList<Int>()
    init {
        for (i in 0 until 100){
            list.add(i)
        }
    }

    inner class MyHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun show(){
            val container = itemView as MaterialCardView
            container.removeAllViews()
            container.addView(TextView(container.context).apply { text = list[adapterPosition].toString() })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(MaterialCardView(parent.context).apply {
            val layPar = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300)
            layPar.setMargins(30)
            layoutParams = layPar
        })
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.show()
    }

    override fun getItemCount(): Int {
        return list.size
    }


}