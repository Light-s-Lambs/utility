package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UnicodeToBinaryEncoderComponent : TextUtilComponent {

    @ExperimentalCoroutinesApi
    private val state: MutableStateFlow<String> by lazy {
        MutableStateFlow("")
    }

    override fun getName(): String = "UnicodeToBinaryEncoder"

    override fun getState(): StateFlow<String> = state

    override fun apply(text: String) {
        state.value = convertStringToBinary(text)
    }

    private fun convertStringToBinary(text: String): String {
        var binStr = ""
        for (char in text.toByteArray())
            binStr += char.toUInt().toString(radix = 2)
        return binStr
    }
}
