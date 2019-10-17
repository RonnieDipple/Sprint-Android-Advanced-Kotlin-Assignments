package com.example.guidedconductordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.example.guidedconductordemo.controllers.HomeController

class MainActivity : AppCompatActivity() {
    private lateinit var router: Router
    private val container: ViewGroup by lazy {
        this.findViewById<ViewGroup>(R.id.activity_main_parent_controller_container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        router = Conductor.attachRouter(this, container, savedInstanceState)
        if (!router.hasRootController()){
            router.setRoot(RouterTransaction.with(HomeController()))//HomeController is a class
        }
    }

    //Handles back button
    override fun onBackPressed() {
        if (!router.handleBack())
        super.onBackPressed()
    }
}
