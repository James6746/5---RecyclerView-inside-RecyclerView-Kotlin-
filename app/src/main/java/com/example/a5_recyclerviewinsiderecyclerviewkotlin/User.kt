package com.example.a5_recyclerviewinsiderecyclerviewkotlin

class User(val name: String?, val subUserArrayList: ArrayList<User>?){
    constructor(name: String?): this(name, null)
}