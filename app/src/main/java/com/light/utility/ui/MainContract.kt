package com.light.utility.ui

interface MainContract {
    interface View {
        val presenter : Presenter
    }

    interface Presenter {
        val view : View
    }
}
