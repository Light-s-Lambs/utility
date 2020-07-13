package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.*

class HexDecoderComponent : TextUtilComponent {

    @ExperimentalCoroutinesApi
    private val state: MutableStateFlow<String> by lazy {
        MutableStateFlow("")
    }

    @ExperimentalCoroutinesApi
    override fun getState(): StateFlow<String> = state

    @ExperimentalCoroutinesApi
    override fun apply(text: String) {
        val uniString = StringBuilder()
        val byteArray = text.toByteArray()

        for (i in 0 until byteArray.size / 2) {
            val char = (((byteArray[i * 2].toInt() - 48) shl 4) + (byteArray[(i * 2) + 1].toInt() - 48)).toChar().toString()
            uniString.append(char)
        }
        state.value = uniString.toString()
    }
}
