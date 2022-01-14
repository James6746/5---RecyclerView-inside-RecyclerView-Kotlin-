package com.example.a5_recyclerviewinsiderecyclerviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class SubUserAdapter(
    private val context: Context,
    private val userArrayList: ArrayList<User>
) :
    RecyclerView.Adapter<SubUserAdapter.SubUserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubUserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_sub_user, parent, false)
        return SubUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubUserViewHolder, position: Int) {
        holder.userName.text = userArrayList[position].name
    }

    override fun getItemCount(): Int {
        return userArrayList.size
    }

    class SubUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var userName = itemView.findViewById<TextView>(R.id.item_name)
    }
}
