package com.light.utility.ui

class MainPresenter constructor(
    override val view: MainContract.View
) : MainContract.Presenter {
    override fun onUserEdited(text: String) {
        view.getChanged(text)
    }
}
