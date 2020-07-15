package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HexDecoderComponent : TextUtilComponent {

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

    private fun convertHexToString(text: String): String {
        var textStr = ""
        var hexChar = ""

        val hexArray = text.toByteArray()

        for (char in hexArray) {
            if (char.toInt() != 0x20)
                hexChar += char.toChar()

            if (hexChar.length == 2) {
                textStr += hexChar.toLong(radix = 16).toChar()
                hexChar = ""
            }
        }

        return textStr
    }
}
