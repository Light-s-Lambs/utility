package com.light.utility.ui

interface MainContract {
    interface View {
        val presenter: Presenter
        fun showText(text: String)
    }

    interface Presenter {
        val view: View
        fun onUserEdited(text: String)
    }
}
