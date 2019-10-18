package com.example.conductorassignment.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.example.conductorassignment.R

class MainController: Controller(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.activity_main, container, false)

        return view
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)
        if (view!=null){
            view?.findViewById<Button>(R.id.button_message)?.setOnClickListener {

                //MainController needs to be changed to the child controller once setup
                router.pushController(RouterTransaction.with(MainController())
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler()))
            }
            view?.findViewById<Button>(R.id.button_phone_number)?.setOnClickListener {
                //MainController needs to be changed to the child controller once setup
                router.pushController(RouterTransaction.with(MainController())
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler()))

            }
        }
    }
}