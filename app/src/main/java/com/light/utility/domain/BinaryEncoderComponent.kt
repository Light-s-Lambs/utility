package com.light.utility.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.*

class BinaryEncoderComponent : TextUtilComponent {

	@ExperimentalCoroutinesApi
	private val state: MutableStateFlow<String> by lazy {
		MutableStateFlow("")
	}

	override fun getState(): StateFlow<String> = state

	override fun apply(text: String) {
		state.value = text.toUInt().toString(radix = 2)
	}
}
