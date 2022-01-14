package com.example.a5_recyclerviewinsiderecyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var userArrayList: ArrayList<User>
    lateinit var userAdapter: UserAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        userArrayList = ArrayList()
        userAdapter = UserAdapter(this, userArrayList)

        for (i in 0..49) {
            if (i == 5 || i == 15 || i == 25) {
                userArrayList.add(User("Matthew Redman", createList()))
            } else {
                userArrayList.add(User("James"))
            }
        }

        recyclerView.layoutManager = GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)
        recyclerView.adapter = userAdapter
    }

    private fun createList(): ArrayList<User> {
        val subUserArrayList = ArrayList<User>()
        for (i in 0..19) {
            subUserArrayList.add(User("Matthew Redman"))
        }
        return subUserArrayList
    }
}