package com.light.utility.ui

import com.light.utility.domain.Base64DecoderComponent
import com.light.utility.domain.Base64EncoderComponent
import com.light.utility.domain.HexDecoderComponent
import com.light.utility.domain.HexEncoderComponent
import com.light.utility.domain.UnicodeToBinaryEncoderComponent
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.Toolkit
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame
import javax.swing.JTextArea

class MainFrame : MainContract.View, JFrame() {
    override val presenter = MainPresenter(this)

    private val textArea by lazy {
        JTextArea()
    }

    init {
        setupView()
        setupEventListeners()

        val binaryEncoderComponent = UnicodeToBinaryEncoderComponent().also { presenter.addList(it) }
        UnicodeToBinaryEncoderFrame(binaryEncoderComponent)

        val base64EncoderComponent = Base64EncoderComponent().also { presenter.addList(it) }
        Base64EncoderFrame(base64EncoderComponent)

        val base64DecoderComponent = Base64DecoderComponent().also { presenter.addList(it) }
        Base64DecoderFrame(base64DecoderComponent)

        val hexEncoderComponent = HexEncoderComponent().also { presenter.addList(it) }
        HexEncoderFrame(hexEncoderComponent)

        val hexDecoderComponent = HexDecoderComponent().also { presenter.addList(it) }
        HexDecoderFrame(hexDecoderComponent)
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
                    presenter.onUserEdited(text)
                }
            })
        }
    }
}
