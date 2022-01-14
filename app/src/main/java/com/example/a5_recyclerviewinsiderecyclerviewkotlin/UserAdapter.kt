package com.example.a5_recyclerviewinsiderecyclerviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val context: Context, val userArrayList: ArrayList<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object{
        val TYPE_ITEM = 0
        val TYPE_List = 1;
    }

    override fun getItemViewType(position: Int): Int {
        if(userArrayList.get(position).subUserArrayList == null){
            return TYPE_ITEM
        } else {
            return TYPE_List
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_ITEM){
            val view: View = LayoutInflater.from(context).inflate(R.layout.activity_user, parent, false)
            return UserViewHolder(view)
        } else {
            val view: View = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false)
            return UserListViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is UserViewHolder){
            holder.userName.text = userArrayList.get(position).name
        } else if(holder is UserListViewHolder){
            val recyclerView: RecyclerView = holder.recyclerView
            recyclerView.layoutManager = GridLayoutManager(context, 1, RecyclerView.HORIZONTAL, false)
            val subUserAdapter = SubUserAdapter(context, userArrayList.get(position).subUserArrayList!!)
            recyclerView.adapter = subUserAdapter
        }
    }

    override fun getItemCount(): Int {
        return userArrayList.size
    }




    class UserViewHolder(view: View): RecyclerView.ViewHolder(view){
        var userName = view.findViewById<TextView>(R.id.item_name)
    }

    class UserListViewHolder(view: View): RecyclerView.ViewHolder(view){
        var recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
    }



}