package com.light.utility.ui

import com.light.utility.BasePresenter
import com.light.utility.BaseView

interface MainContract {
    interface View : BaseView<Presenter>

    interface Presenter : BasePresenter {
        fun onUserEdited(text: String)
    }
}
