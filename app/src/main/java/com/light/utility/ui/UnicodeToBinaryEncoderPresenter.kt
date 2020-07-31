package com.light.utility.ui

import com.light.utility.domain.TextUtilComponent
import com.light.utility.domain.UnicodeToBinaryEncoderComponent

class UnicodeToBinaryEncoderPresenter : EncoderContract.Presenter {
    private val component = UnicodeToBinaryEncoderComponent()
    val view = UnicodeToBinaryEncoderFrame(this)

    override fun onUserEdited(text: String) {
        component.apply(text)
    }
}
