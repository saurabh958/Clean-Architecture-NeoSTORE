package com.example.cleanneo.util

import android.content.Context

class App {
    private var context: Context? = null

    fun setContext(cntxt: Context?) {
        context = cntxt
    }

    fun getContext(): Context? {
        return context
    }
}