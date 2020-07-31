package com.light.utility.ui

import com.light.utility.domain.Base64EncoderComponent

class Base64EncoderPresenter : EncoderContract.Presenter {
    private val component = Base64EncoderComponent()
    private val view = Base64EncoderFrame(this)

    override fun onUserEdited(text: String) {
        component.apply(text)
        view.showSuccessfullyEncoded(component.getState().value)
    }
}
