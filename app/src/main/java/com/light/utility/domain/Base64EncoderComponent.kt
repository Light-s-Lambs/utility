package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Base64

class Base64EncoderComponent : TextUtilComponent {

    @ExperimentalCoroutinesApi
    private val state: MutableStateFlow<String> by lazy {
        MutableStateFlow("")
    }

    override fun getName(): String = "Base64Encoder"

    override fun getState(): StateFlow<String> = state

    override fun apply(text: String) {
        state.value = Base64.getEncoder().encodeToString(text.toByteArray())
    }
}
