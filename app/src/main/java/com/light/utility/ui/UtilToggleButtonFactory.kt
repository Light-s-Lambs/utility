package com.light.utility.ui

import com.light.utility.domain.*

class UtilToggleButtonFactory constructor(
    private val frameFactory: UtilFrameFactory
) {

    fun create(component: UtilComponent): UtilToggleButton =
        when (component) {
            is Base64DecoderComponent -> {
                UtilToggleButton(frameFactory, component)
            }
            is Base64EncoderComponent -> {
                UtilToggleButton(frameFactory, component)
            }
            is HexDecoderComponent -> {
                UtilToggleButton(frameFactory, component)
            }
            is HexEncoderComponent -> {
                UtilToggleButton(frameFactory, component)
            }
            is UnicodeToBinaryEncoderComponent -> {
                UtilToggleButton(frameFactory, component)
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
}
