package com.light.utility.ui

import com.light.utility.domain.Base64EncoderComponent

class Base64EncoderPresenter constructor(
    private val view: Base64EncoderFrame,
    private val component: Base64EncoderComponent
) : EncoderContract.Presenter {

    override fun onUserEdited(text: String) {
        if (isValidString()) {
            component.apply(text)
            if (isEncodeSuccessful())
                view.showSuccessfullyEncoded(component.getState().value)
            else
                view.showEncodingFailed()
        }
        else
            view.showValidationFailed()
    }
    private fun isValidString() = true
    private fun isEncodeSuccessful() = true
}
