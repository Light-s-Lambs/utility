package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Base64

class Base64DecoderComponent : TextUtilComponent {

    companion object { private const val INVALID_INPUT_MESSAGE = "Check your Input" }

    @ExperimentalCoroutinesApi
    private val state: MutableStateFlow<String> by lazy {
        MutableStateFlow("")
    }

    override fun getState(): StateFlow<String> = state

    override fun apply(text: String) {
        state.value = if (isBase64Str(text))
            convertBase64toString(text)
        else
            INVALID_INPUT_MESSAGE
    }

    private fun convertBase64toString(text: String): String {
        val paddingStripped = text.split("=").first()
        return String(Base64.getDecoder().decode(paddingStripped))
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
