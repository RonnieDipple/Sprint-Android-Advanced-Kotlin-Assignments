package com.example.conductorassignment.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.example.conductorassignment.R
import kotlinx.android.synthetic.main.activity_main.view.*

class ChildMessageController<T>()  : Controller()
        where T: Controller, T: ChildMessageController.ChildContainer{

    constructor(targetController: T): this() {
        setTargetController(targetController)
    }

    interface ChildContainer {
        fun receiveMessage(string: String)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.message_layout, container, false)
        view.tv_main_layout_message.text = "Message controller"
        return view

    }
    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)
        val buttonMessage = view?.findViewById<Button>(R.id.button_message_layout)


        buttonMessage?.setOnClickListener {
            //Pass data to parent

        }


    }
}