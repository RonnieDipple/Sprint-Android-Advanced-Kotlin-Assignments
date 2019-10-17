package com.example.assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

//Extension function to inflate layout
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false ): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}