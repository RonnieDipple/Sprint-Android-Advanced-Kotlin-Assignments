package com.example.conductorassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.example.conductorassignment.controllers.MainController
import kotlinx.android.synthetic.main.activity_main.*
/*#### *Sprint 11: Module 4*

Assignment

---


## Overview
Build an app which has a root view that shows 2 buttons. Each button navigates to a separate View.

## Requirements
This app will consist of a Root Controller and 2 Sub controllers

## Outline
1. Create a project with Conductor
2. Add a Root Controller
3. Add 2 Sub Controllers
4. Experiment with various Change Handlers to define what happens (visually) when going to/from each controller

## Go Further
- Ensure that the backstack works properly with the Router*/
class MainActivity : AppCompatActivity() {


    private lateinit var router: Router
    private val container: ViewGroup by lazy{
        this.findViewById<ViewGroup>(R.id.main_controller_container)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        router = Conductor.attachRouter(this, container, savedInstanceState)


            if (!router.hasRootController()) {
                router.setRoot(RouterTransaction.with(MainController()))

            }

    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }
}
