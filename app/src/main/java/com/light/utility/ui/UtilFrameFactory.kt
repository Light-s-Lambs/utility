package com.light.utility.ui

import com.light.utility.domain.*
import javax.swing.JFrame

class UtilFrameFactory {
    fun create(component: UtilComponent): JFrame =
        when (component) {
            is Base64DecoderComponent -> {
                Base64DecoderFrame(component)
            }
            is Base64EncoderComponent -> {
                Base64EncoderFrame(component)
            }
            is HexDecoderComponent -> {
                HexDecoderFrame(component)
            }
            is HexEncoderComponent -> {
                HexEncoderFrame(component)
            }
            is UnicodeToBinaryEncoderComponent -> {
                UnicodeToBinaryEncoderFrame(component)
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
}
