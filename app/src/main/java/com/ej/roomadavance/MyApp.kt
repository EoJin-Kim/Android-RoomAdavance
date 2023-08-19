package com.ej.roomadavance

import android.app.Application
import android.content.Context
import com.ej.roomadavance.db.MyDatabase

class MyApp : Application() {

    init {
        instance = this
    }

    companion object{
        private var instance : MyApp? = null

        fun context() : Context{
            return instance!!.applicationContext
        }
    }
}