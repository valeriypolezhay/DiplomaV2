package com.example.diploma.khaiid

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.user_row.view.*

class MainAdapter(val usersFeed: Array<User>) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        // return usersFeed.users.count()
       return usersFeed.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.user_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        //val card = usersFeed.users.get(position)
val card = usersFeed[position]
        val space = " "
        val enter = "\n"

//        val usertext =usersFeed.firstName.ua + space + usersFeed.middleName.ua+space+usersFeed.lastName.ua+enter+
//                usersFeed.firstName.ru + space + usersFeed.middleName.ru+space+usersFeed.lastName.ru+enter+
//                usersFeed.firstName.en + space + usersFeed.middleName.en+space+usersFeed.lastName.en+enter

        val usertext =card.firstName.ua + space + card.middleName.ua+space+card.lastName.ua+enter+
                card.firstName.ru + space + card.middleName.ru+space+card.lastName.ru+enter+
                card.firstName.en + space + card.middleName.en+space+card.lastName.en+enter


        holder?.view?.textView_user?.text = usertext
        holder?.view?.textView_user_id?.text = card.user_id


    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view)