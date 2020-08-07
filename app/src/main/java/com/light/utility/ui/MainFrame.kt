package com.light.utility.ui

import com.light.utility.domain.Base64DecoderComponent
import com.light.utility.domain.Base64EncoderComponent
import com.light.utility.domain.HexDecoderComponent
import com.light.utility.domain.HexEncoderComponent
import com.light.utility.domain.OctDecoderComponent
import com.light.utility.domain.OctEncoderComponent
import com.light.utility.domain.TextUtilComponent
import com.light.utility.domain.UnicodeToBinaryEncoderComponent
import com.light.utility.domain.UtilComponent
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.Toolkit
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame
import javax.swing.JTextArea

class MainFrame : JFrame() {

    private val textArea by lazy {
        JTextArea()
    }

    val utils by lazy {
        mutableListOf<UtilComponent>()
    }

    init {
        setupView()
        setupEventListeners()

        val binaryEncoderComponent = UnicodeToBinaryEncoderComponent().also { utils.add(it) }
        UnicodeToBinaryEncoderFrame(binaryEncoderComponent)

        val base64EncoderComponent = Base64EncoderComponent().also { utils.add(it) }
        Base64EncoderFrame(base64EncoderComponent)

        val base64DecoderComponent = Base64DecoderComponent().also { utils.add(it) }
        Base64DecoderFrame(base64DecoderComponent)

        val hexEncoderComponent = HexEncoderComponent().also { utils.add(it) }
        HexEncoderFrame(hexEncoderComponent)

        val hexDecoderComponent = HexDecoderComponent().also { utils.add(it) }
        HexDecoderFrame(hexDecoderComponent)

        val octEncoderComponent = OctEncoderComponent().also { utils.add(it) }
        HexEncoderFrame(octEncoderComponent)

        val octDecoderComponent = OctDecoderComponent().also { utils.add(it) }
        HexDecoderFrame(octDecoderComponent)
    }

    private fun setupView() {
        defaultCloseOperation = EXIT_ON_CLOSE
        val screenSize = Toolkit.getDefaultToolkit().screenSize
        size = Dimension(screenSize.width / 2, screenSize.height / 2)
        layout = BorderLayout()
        add(textArea, BorderLayout.CENTER)
        isVisible = true
    }

    private fun setupEventListeners() {
        textArea.apply {
            addKeyListener(object : KeyListener {
                override fun keyTyped(p0: KeyEvent?) {
                }

                override fun keyPressed(p0: KeyEvent?) {
                }

                override fun keyReleased(p0: KeyEvent?) {
                    utils
                        .filterIsInstance(TextUtilComponent::class.java)
                        .forEach {
                            it.apply(text)
                        }
                }
            })
        }
    }
}
