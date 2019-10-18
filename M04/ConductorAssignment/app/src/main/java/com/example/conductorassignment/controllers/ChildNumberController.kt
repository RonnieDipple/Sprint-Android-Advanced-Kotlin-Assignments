package com.example.conductorassignment.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.example.conductorassignment.R
import kotlinx.android.synthetic.main.activity_main.view.*

class ChildNumberController:Controller{
    constructor()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.phone_number_layout, container, false)

        view.tv_main.text = "Number controller"
        return view
    }




}