package com.light.utility.ui

import com.light.utility.domain.Base64DecoderComponent
import com.light.utility.domain.Base64EncoderComponent
import com.light.utility.domain.HexDecoderComponent
import com.light.utility.domain.HexEncoderComponent
import com.light.utility.domain.TextUtilComponent
import com.light.utility.domain.UnicodeToBinaryEncoderComponent
import com.light.utility.domain.UtilComponent
import java.lang.IllegalArgumentException
import javax.swing.JFrame
import javax.swing.JToggleButton

class ToggleButtonFactory : JToggleButton() {
    enum class ClassType {
        UniCodeToBinaryEncoder, Base64Encoder, Base64Decoder, HexEncoder, HexDecoder
    }

    fun createToggleButton(type: ClassType, componentList: MutableList<UtilComponent>): JToggleButton {
        when (type) {
            ClassType.UniCodeToBinaryEncoder -> {
                val unicodeToBinaryEncoderButton = JToggleButton("U2B Encoder")
                addButtonAction <UnicodeToBinaryEncoderComponent, UnicodeToBinaryEncoderFrame>(unicodeToBinaryEncoderButton, componentList)
                return unicodeToBinaryEncoderButton
            }
            ClassType.Base64Encoder -> {
                val base64EncoderButton = JToggleButton("Base64 Encoder")
                addButtonAction <Base64EncoderComponent, Base64EncoderFrame>(base64EncoderButton, componentList)
                return base64EncoderButton
            }
            ClassType.Base64Decoder -> {
                val base64DecoderButton = JToggleButton("Base64 Decoder")
                addButtonAction <Base64DecoderComponent, Base64DecoderFrame>(base64DecoderButton, componentList)
                return base64DecoderButton
            }
            ClassType.HexEncoder -> {
                val hexEncoderButton = JToggleButton("Hex Encoder")
                addButtonAction <HexEncoderComponent, HexEncoderFrame>(hexEncoderButton, componentList)
                return hexEncoderButton
            }
            ClassType.HexDecoder -> {
                val hexDecoderButton = JToggleButton("Hex Decoder")
                addButtonAction <HexDecoderComponent, HexDecoderFrame>(hexDecoderButton, componentList)
                return hexDecoderButton
            }
            else -> {
                throw IllegalArgumentException("Wrong Parameter")
            }
        }
    }

    private inline fun <reified componentClass : UtilComponent, reified frameClass : JFrame> addButtonAction(btn: JToggleButton, componentList: MutableList<UtilComponent>) {
        lateinit var frame: frameClass
        btn.addActionListener {
            if (btn.isSelected) {
                val component = componentClass::class.java.newInstance().also { componentList.add(it) }
                val frameConstructor = frameClass::class.java.getConstructor(TextUtilComponent::class.java)
                frame = frameConstructor.newInstance(component)
            } else {
                componentList.removeIf { it == componentClass::class.java }
                frame.dispose()
            }
        }
    }
}
