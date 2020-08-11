package com.light.utility.ui

import com.light.utility.domain.UtilComponent

interface MainContract {
    interface View {
        val presenter: Presenter
    }

    interface Presenter {
        val view: View
        fun onUserEdited(text: String)
        fun addList(component: UtilComponent)
    }
}
