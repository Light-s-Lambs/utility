package com.light.utility.domain

import kotlinx.coroutines.flow.StateFlow

interface TextUtilComponent : UtilComponent {
    fun getState(): StateFlow<String>

    fun apply(text: String)
}
