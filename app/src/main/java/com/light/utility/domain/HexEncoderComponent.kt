package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HexEncoderComponent : TextUtilComponent {

    @ExperimentalCoroutinesApi
    private val state: MutableStateFlow<String> by lazy {
        MutableStateFlow("")
    }

    @ExperimentalCoroutinesApi
    override fun getState(): StateFlow<String> = state

    @ExperimentalCoroutinesApi
    override fun apply(text: String) {
        state.value = convertStringToHex(text)
    }

    private fun convertStringToHex(text: String): String {
        return text.toByteArray()
            .map { charToHexDigit(it) }
            .joinToString(" ")
    }

    private fun charToHexDigit(char: Byte): String {
        return char.toUInt().toString(16)
    }
}
