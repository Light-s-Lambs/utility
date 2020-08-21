package com.light.utility.ui

import com.light.utility.domain.Base64DecoderComponent
import com.light.utility.domain.Base64EncoderComponent
import com.light.utility.domain.HexDecoderComponent
import com.light.utility.domain.HexEncoderComponent
import com.light.utility.domain.UnicodeToBinaryEncoderComponent
import com.light.utility.domain.UtilComponent
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
