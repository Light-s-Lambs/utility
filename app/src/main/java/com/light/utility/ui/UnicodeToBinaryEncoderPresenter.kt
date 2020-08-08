package com.light.utility.ui

import com.light.utility.domain.TextUtilComponent

class UnicodeToBinaryEncoderPresenter constructor(
    private val view: EncoderContract.View,
    private val component: TextUtilComponent
) : EncoderContract.Presenter {
    override fun onUserEdited(text: String) {
        if (isValidString()) {
            component.apply(text)
            if (isEncodeSuccessful())
                view.showSuccessfullyEncoded(component.getState().value)
            else
                view.showEncodingFailed()
        } else
            view.showValidationFailed()
    }

    private fun isValidString() = true
    private fun isEncodeSuccessful() = true
}
