package com.example.guidedconductordemo.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.example.guidedconductordemo.R

class HomeController(private var message: String? = null): BaseController(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
       val view = inflater.inflate(R.layout.home_controller_layout, container, false)
        view.findViewById<TextView>(R.id.home_textView).text = message?: "Hello Conductor!\nController${router.backstackSize}"
        return view
    }

    fun getMessage(string: String){

    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)

        if (view != null){
            view?.findViewById<Button>(R.id.next_button)?.setOnClickListener {


                router.pushController(RouterTransaction.with(HomeController("New HomeController ${router.backstackSize}"))
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler()))

            }
        }

        val prevButton = view?.findViewById<Button>(R.id.previous_button)
        if(router.backstackSize <= 1){
            prevButton?.visibility = View.GONE

            }else{
                prevButton?.setOnClickListener {
                    (parentController as HomeController).getMessage("new message")
            }
        }

    }
}