package com.light.utility.ui

import com.light.utility.domain.HexDecoderComponent

class HexDecoderPresenter constructor(
    private val view: HexDecoderFrame,
    private val component: HexDecoderComponent
) : EncoderContract.Presenter {
    override fun onUserEdited(text: String) {
        if (isHexString(text)) {
            component.apply(text)
            if (isEncodeSuccessful())
                view.showSuccessfullyEncoded(component.getState().value)
            else
                view.showEncodingFailed()
        } else {
            view.showValidationFailed()
        }
    }

    private fun isHexDigit(char: Char): Boolean {
        val hexChars = "abcdefABCDEF"
        return char.isDigit() || (char in hexChars)
    }

    private fun isHexString(hexStr: String): Boolean {
        val hexArray = hexStr.toByteArray()

        for (char in hexArray) {
            if (!isHexDigit(char.toChar()) && !char.toChar().isWhitespace())
                return false
        }

        return true
    }

    private fun isEncodeSuccessful() = true
}
