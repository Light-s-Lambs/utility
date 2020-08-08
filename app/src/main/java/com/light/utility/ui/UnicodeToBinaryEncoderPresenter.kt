package com.light.utility.ui

import com.light.utility.domain.UnicodeToBinaryEncoderComponent

class UnicodeToBinaryEncoderPresenter constructor(
    private val view: EncoderContract.View,
    private val component: UnicodeToBinaryEncoderComponent
) : EncoderContract.Presenter {
    override fun onUserEdited(text: String) {
        component.apply(text)
        view.showSuccessfullyEncoded(component.getState().value)
    }
}
