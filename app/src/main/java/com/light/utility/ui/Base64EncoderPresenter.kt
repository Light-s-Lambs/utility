package com.light.utility.ui

import com.light.utility.domain.Base64EncoderComponent

class Base64EncoderPresenter constructor(
    private val view: Base64EncoderFrame,
    private val component: Base64EncoderComponent
) : EncoderContract.Presenter {

    override fun onUserEdited(text: String) {
        component.apply(text)
        view.showSuccessfullyEncoded(component.getState().value)
    }
}
