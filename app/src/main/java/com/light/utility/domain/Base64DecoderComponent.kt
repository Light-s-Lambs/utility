package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Base64

const val err_msg = "Check your Input"

class Base64DecoderComponent : TextUtilComponent {

    @ExperimentalCoroutinesApi
    private val state: MutableStateFlow<String> by lazy {
        MutableStateFlow("")
    }

    override fun getState(): StateFlow<String> = state

    override fun apply(text: String) {
        state.value = if (isBase64Str(text))
            convertBase64toString(text)
        else
            err_msg
    }

    private fun convertBase64toString(text: String): String {
        val base64StrNoPad = text.split("=")[0]
        return String(Base64.getDecoder().decode(base64StrNoPad))
    }

    private fun isBase64Str(text: String): Boolean {
        return (text.toByteArray().count { !isBase64Char(it.toChar()) }) == 0
    }

    private fun isBase64Char(char: Char): Boolean {
        return char.isUpperCase() || char.isLowerCase() || char.isDigit() || char == '+' || char == '/' || char == '='
    }
}
