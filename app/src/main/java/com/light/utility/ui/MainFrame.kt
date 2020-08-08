package com.light.utility.ui

import com.light.utility.BasePresenter
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

class MainFrame : JFrame() {
    private val textArea by lazy {
        JTextArea()
    }

    private val utils by lazy {
        mutableListOf<BasePresenter>()
    }

    init {
        setupView()
        setupEventListeners()

        UnicodeToBinaryEncoderFrame(UnicodeToBinaryEncoderComponent()).also { utils.add(it.presenter) }
        Base64EncoderFrame(Base64EncoderComponent()).also { utils.add(it.presenter) }
        Base64DecoderFrame(Base64DecoderComponent()).also { utils.add(it.presenter) }
        HexEncoderFrame(HexEncoderComponent()).also { utils.add(it.presenter) }
        HexDecoderFrame(HexDecoderComponent()).also { utils.add(it.presenter) }
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
