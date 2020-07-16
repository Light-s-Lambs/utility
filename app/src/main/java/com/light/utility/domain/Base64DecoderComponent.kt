package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Base64

class Base64DecoderComponent : TextUtilComponent {

    @ExperimentalCoroutinesApi
    private val state: MutableStateFlow<String> by lazy {
        MutableStateFlow("")
    }

    override fun getState(): StateFlow<String> = state

    override fun apply(text: String) {
        state.value = convertBase64toString(text)
    }

    private fun convertBase64toString(text: String): String {
        val isBase64Str = text.toByteArray().count { !isBase64(it.toChar()) }
        return if (isBase64Str > 0)
            "Check Your Input."
        else
            String(Base64.getDecoder().decode(text))
    }

    private fun isBase64(char: Char): Boolean {
        return char.isUpperCase() || char.isLowerCase() || char.isDigit() || char.equals("+") || char.equals("/")
    }
}
