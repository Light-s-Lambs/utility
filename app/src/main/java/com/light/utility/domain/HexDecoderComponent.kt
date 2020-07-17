package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

const val err_msg = "Check your Input"

class HexDecoderComponent : TextUtilComponent {
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
            state.value = err_msg
        else
            state.value = hexStr
    }

    private fun convertHexToString(text: String): String {
        if (isHexString(text)) {
            var textStr = ""
            var hexChar = ""

            val hexArray = text.toByteArray().filter { isHexDigit(it.toChar()) }.toByteArray()

            for (char in hexArray) {
                hexChar += char.toChar()

                if (hexChar.length == 2) {
                    textStr += hexChar.toLong(radix = 16).toChar()
                    hexChar = ""
                }
            }

            return textStr
        }

        return ""
    }

    private fun isHexDigit(char: Char): Boolean {
        val hexChars = "abcdefABCDEF"
        return char.isDigit() || (char in hexChars)
    }

    private fun isHexString(hexStr: String): Boolean {
        val hexArray = hexStr.toByteArray()

        for (char in hexArray) {
            if ((!isHexDigit(char.toChar())) && (!char.toChar().isWhitespace()))
                return false
        }

        return true
    }
}
