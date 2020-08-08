package com.light.utility.ui

import com.light.utility.domain.TextUtilComponent

class HexEncoderPresenter constructor(
    private val view: HexEncoderFrame,
    private val component: TextUtilComponent
) : EncoderContract.Presenter {
    override fun onUserEdited(text: String) {
        if (isValidString()) {
            component.apply(text)
            if (isEncodeSuccessful())
                view.showSuccessfullyEncoded(component.getState().value)
            else
                view.showEncodingFailed()
        } else {
            view.showValidationFailed()
        }
    }

    private fun isValidString() = true
    private fun isEncodeSuccessful() = true
}
