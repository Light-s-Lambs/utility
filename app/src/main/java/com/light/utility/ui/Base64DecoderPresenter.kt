package com.light.utility.ui

import com.light.utility.domain.Base64DecoderComponent

class Base64DecoderPresenter : EncoderContract.Presenter {
    private val component = Base64DecoderComponent()
    private val view = Base64DecoderFrame(this)

    override fun onUserEdited(text: String) {
        if(isBase64Str(text)) {
            component.apply(text)
            view.showSuccessfullyEncoded(component.getState().value)
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
}
