package com.example.diploma.khaiid.Fragments

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diploma.khaiid.R


class RecyclerFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context).inflate(R.layout.users_recycler,container,false)
    }
}