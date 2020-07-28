package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HexDecoderComponent : TextUtilComponent {
    companion object {
        const val HEX_DECODING_INPUT_ERROR = "Check your Input"
        const val EMPTY_STRING_DECODE_FAILED = ""
    }

    @ExperimentalCoroutinesApi
    private val state: MutableStateFlow<String> by lazy {
        MutableStateFlow("")
    }

    @ExperimentalCoroutinesApi
    override fun getState(): StateFlow<String> = state

    @ExperimentalCoroutinesApi
    override fun apply(text: String) {
        val hexStr = convertHexToString(text)

        if (hexStr.isEmpty())
            state.value = HEX_DECODING_INPUT_ERROR
        else
            state.value = hexStr
    }

    private fun convertHexToString(text: String): String =
        if (isHexString(text)) {
            text.replace("\\s".toRegex(), "")
                .chunked(2)
                .map { hexDigitToChar(it) }
                .joinToString("")
        } else {
            EMPTY_STRING_DECODE_FAILED
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

    private fun hexDigitToChar(hexDigit: String): Char {
        return hexDigit.toLong(radix = 16).toChar()
    }
}
