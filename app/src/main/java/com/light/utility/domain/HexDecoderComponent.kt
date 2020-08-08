package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HexDecoderComponent : TextUtilComponent {
    companion object {
        const val HEX_DECODING_INPUT_ERROR = "Check your Input"
        const val EMPTY_STRING = ""
    }

    @ExperimentalCoroutinesApi
    private val state: MutableStateFlow<String> by lazy {
        MutableStateFlow("")
    }

    @ExperimentalCoroutinesApi
    override fun getState(): StateFlow<String> = state

    @ExperimentalCoroutinesApi
    override fun apply(text: String) {
        state.value = convertHexToString(text)
    }

    private fun convertHexToString(text: String): String =
        removeWhitespace(text)
            .chunked(2)
            .map { hexDigitToChar(it) }
            .joinToString("")

    private fun hexDigitToChar(hexDigit: String): Char {
        return hexDigit.toLong(radix = 16).toChar()
    }

    private fun removeWhitespace(hexString: String): String {
        return hexString.replace("\\s".toRegex(), "")
    }
}
