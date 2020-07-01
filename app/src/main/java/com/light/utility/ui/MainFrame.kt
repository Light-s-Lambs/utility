package com.light.utility.ui

import com.light.utility.domain.Base64EncoderComponent
import com.light.utility.domain.BinaryEncoderComponent
import com.light.utility.domain.TextUtilComponent
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

        val base64EncoderComponent = Base64EncoderComponent()
            .also {
                utils.add(it)
            }
        Base64EncoderFrame(base64EncoderComponent)
		val binaryEncoderComponent = BinaryEncoderComponent()
			.also {
				utils.add(it)
			}
		BinaryEncoderFrame(binaryEncoderComponent)
    }

    private fun setupView() {
        defaultCloseOperation = EXIT_ON_CLOSE
        val screenSize = Toolkit.getDefaultToolkit().screenSize
        size = Dimension(screenSize.width / 2, screenSize.height / 2)
        isVisible = true

        layout = BorderLayout()

        add(textArea, BorderLayout.CENTER)
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
