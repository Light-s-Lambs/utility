package com.light.utility.ui

import com.light.utility.domain.Base64DecoderComponent
import com.light.utility.domain.Base64EncoderComponent
import com.light.utility.domain.UnicodeToBinaryEncoderComponent
import com.light.utility.domain.UtilComponent
import java.lang.IllegalArgumentException
import javax.swing.JToggleButton

class ToggleButtonFactory : JToggleButton() {
    enum class ClassType {
        UniCodeToBinaryEncoder, Base64Encoder, Base64Decoder
    }

    fun createToggleButton(type: ClassType, componentList: MutableList<UtilComponent>): JToggleButton {
        when (type) {
            ClassType.UniCodeToBinaryEncoder -> {
                val unicodeToBinaryEncoderButton = JToggleButton("U2B Encoder")
                addButtonAction(unicodeToBinaryEncoderButton, type, componentList)
                return unicodeToBinaryEncoderButton
            }
            ClassType.Base64Encoder -> {
                val base64EncoderButton = JToggleButton("Base64 Encoder")
                addButtonAction(base64EncoderButton, type, componentList)
                return base64EncoderButton
            }
            ClassType.Base64Decoder -> {
                val base64DecoderButton = JToggleButton("Base64 Decoder")
                addButtonAction(base64DecoderButton, type, componentList)
                return base64DecoderButton
            }
            else -> {
                throw IllegalArgumentException("Wrong Parameter")
            }
        }
    }

    private fun addButtonAction(btn: JToggleButton, t: ClassType, componentList: MutableList<UtilComponent>) {
        when (t) {
            ClassType.UniCodeToBinaryEncoder -> {
                lateinit var unicodeToBinaryEncoderFrame: UnicodeToBinaryEncoderFrame
                btn.addActionListener {
                    if (btn.isSelected) {
                        val binaryEncoderComponent = UnicodeToBinaryEncoderComponent().also { componentList.add(it) }
                        unicodeToBinaryEncoderFrame = UnicodeToBinaryEncoderFrame(binaryEncoderComponent)
                    } else {
                        componentList.removeIf { it == UnicodeToBinaryEncoderComponent::class.java }
                        unicodeToBinaryEncoderFrame.dispose()
                    }
                }
            }
            ClassType.Base64Encoder -> {
                lateinit var base64EncoderFrame: Base64EncoderFrame
                btn.addActionListener {
                    if (btn.isSelected) {
                        val base64EncoderComponent = Base64EncoderComponent().also { componentList.add(it) }
                        base64EncoderFrame = Base64EncoderFrame(base64EncoderComponent)
                    } else {
                        componentList.removeIf { it == Base64EncoderComponent::class.java }
                        base64EncoderFrame.dispose()
                    }
                }
            }
            ClassType.Base64Decoder -> {
                lateinit var base64DecoderFrame: Base64DecoderFrame
                btn.addActionListener {
                    if (btn.isSelected) {
                        val base64DecoderComponent = Base64DecoderComponent().also { componentList.add(it) }
                        base64DecoderFrame = Base64DecoderFrame(base64DecoderComponent)
                    } else {
                        componentList.removeIf { it == Base64DecoderComponent::class.java }
                        base64DecoderFrame.dispose()
                    }
                }
            }
        }
    }
}
