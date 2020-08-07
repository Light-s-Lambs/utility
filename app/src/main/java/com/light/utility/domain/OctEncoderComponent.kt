package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OctEncoderComponent : TextUtilComponent {

    @ExperimentalCoroutinesApi
    private val state: MutableStateFlow<String> by lazy {
        MutableStateFlow("")
    }

    @ExperimentalCoroutinesApi
    override fun getState(): StateFlow<String> = state

    @ExperimentalCoroutinesApi
    override fun apply(text: String) {
        state.value = convertStringToOct(text)
    }

    private fun convertStringToOct(text: String): String {
        return text.toByteArray()
            .map { charToOctDigit(it) }
            .joinToString(" ")
    }

    private fun charToOctDigit(char: Byte): String {
        return char.toUInt().toString(8)
    }
}
