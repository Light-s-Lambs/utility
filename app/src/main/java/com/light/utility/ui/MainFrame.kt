package com.light.utility.ui

import com.light.utility.BasePresenter
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.Toolkit
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame
import javax.swing.JTextArea

class MainFrame constructor(
) : JFrame() {
    private val textArea by lazy {
        JTextArea()
    }

    private val utils by lazy {
        mutableListOf<BasePresenter>()
    }

    init {
        setupView()
        setupEventListeners()

        UnicodeToBinaryEncoderPresenter().also { utils.add(it) }
        Base64EncoderPresenter().also { utils.add(it) }
        Base64DecoderPresenter().also { utils.add(it) }
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
                        .filterIsInstance(EncoderContract.Presenter::class.java)
                        .forEach {
                            it.onUserEdited(text)
                        }
                }
            })
        }
    }
}
