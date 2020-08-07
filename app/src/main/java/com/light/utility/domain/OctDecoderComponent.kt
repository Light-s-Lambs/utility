package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OctDecoderComponent : TextUtilComponent {
    companion object {
        const val OCT_DECODING_INPUT_ERROR = "Check your Input"
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
        val decoded_oct_string = convertOctToString(text)

        if (decoded_oct_string.isEmpty())
            state.value = OCT_DECODING_INPUT_ERROR
        else
            state.value = decoded_oct_string
    }

    private fun convertOctToString(octStr: String): String =
        if (isOctString(octStr)) {
            octStr.split("\\s".toRegex())
                .map { octDigitToChar(it) }
                .joinToString("")
        } else {
            EMPTY_STRING
        }

    private fun isOctString(octStr: String): Boolean {
        val octArray = octStr.toByteArray()

        for (char in octArray) {
            if (!isOctDigit(char.toChar()) && !char.toChar().isWhitespace())
                return false
        }

        return true
    }

    private fun isOctDigit(char: Char): Boolean {
        val octChars = "01234567"
        return char.isDigit() || (char in octChars)
    }

    private fun octDigitToChar(octDigit: String): Char {
        return octDigit.toLong(radix = 8).toChar()
    }
}
