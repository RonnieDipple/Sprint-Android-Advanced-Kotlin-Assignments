package com.example.conductorassignment.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.example.conductorassignment.R
import kotlinx.android.synthetic.main.activity_main.view.*

class MainController: Controller, ChildMessageController.ChildContainer, ChildNumberController.ChildContainer{
    override fun receiveMessage(int: Int) {
        //This is incorrect
        view?.tv_main_layout_message?.text =view?.findViewById<EditText>(R.id.et_message_layout)?.text.toString()
    }

    override fun receiveMessage(string: String) {

        //this is incorrect
        view?.findViewById<EditText>(R.id.et_number_layout)?.text.toString()
    }


    constructor()

    //will need to setup both children to receive bundle
      constructor(args: Bundle): super(args)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.activity_main, container, false)

        view.tv_main_layout_message.text = "test"
        return view
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)
        if (view!=null){
            view?.findViewById<Button>(R.id.button_message_main)?.setOnClickListener {

                //MainController needs to be changed to the child controller once setup
                router.pushController(RouterTransaction.with(ChildMessageController(this))
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler()))
            }
            view?.findViewById<Button>(R.id.button_phone_number_main)?.setOnClickListener {
                //MainController needs to be changed to the child controller once setup
                router.pushController(RouterTransaction.with(ChildNumberController(this))
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler()))

            }
        }
    }
}