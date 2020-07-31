package com.light.utility.ui

import com.light.utility.domain.UnicodeToBinaryEncoderComponent

class UnicodeToBinaryEncoderPresenter : EncoderContract.Presenter {
    private val component = UnicodeToBinaryEncoderComponent()
    private val view = UnicodeToBinaryEncoderFrame(this)

    override fun onUserEdited(text: String) {
        component.apply(text)
        view.showSuccessfullyEncoded(component.getState().value)
    }
}
