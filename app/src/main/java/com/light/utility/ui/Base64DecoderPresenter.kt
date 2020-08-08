package com.light.utility.ui

import com.light.utility.domain.Base64DecoderComponent

class Base64DecoderPresenter constructor(
    private val view: Base64DecoderFrame,
    private val component: Base64DecoderComponent
) : EncoderContract.Presenter {
    override fun onUserEdited(text: String) {
        if (isBase64Str(text)) {
            component.apply(text)
            if (isEncodeSuccessful())
                view.showSuccessfullyEncoded(component.getState().value)
            else
                view.showEncodingFailed()
        } else {
            view.showValidationFailed()
        }
    }

    private fun isBase64Str(text: String): Boolean {
        if (text.length > 1)
            return (text.toByteArray().count { !isBase64Char(it.toChar()) }) == 0
        return false
    }

    private fun isBase64Char(char: Char): Boolean {
        return char.isUpperCase() || char.isLowerCase() || char.isDigit() || char == '+' || char == '/' || char == '='
    }

    private fun isEncodeSuccessful() = true
}
