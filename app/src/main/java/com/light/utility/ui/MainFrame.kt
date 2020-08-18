package com.light.utility.ui

import com.light.utility.domain.Base64DecoderComponent
import com.light.utility.domain.Base64EncoderComponent
import com.light.utility.domain.HexDecoderComponent
import com.light.utility.domain.HexEncoderComponent
import com.light.utility.domain.TextUtilComponent
import com.light.utility.domain.UnicodeToBinaryEncoderComponent
import com.light.utility.domain.UtilComponent
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.Toolkit
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextArea

class MainFrame : JFrame() {

    private val textArea by lazy {
        JTextArea()
    }

    private val utils by lazy {
        mutableListOf<UtilComponent>()
    }

    private val frameFactory = UtilFrameFactory()

    init {
        setupComponent()
        setupView()
        setupEventListeners()
    }

    private fun setupComponent() {
        utils.apply {
            add(UnicodeToBinaryEncoderComponent())
            add(Base64EncoderComponent())
            add(Base64DecoderComponent())
            add(HexEncoderComponent())
            add(HexDecoderComponent())
        }
    }

    private fun setupButton(sideBarPanel: JPanel) {
        utils.forEach { component ->
            sideBarPanel.add(UtilToggleButton(frameFactory, component))
        }
    }

    private fun setupView() {
        defaultCloseOperation = EXIT_ON_CLOSE
        val screenSize = Toolkit.getDefaultToolkit().screenSize
        size = Dimension(screenSize.width / 2, screenSize.height / 2)
        layout = BorderLayout()
        add(textArea, BorderLayout.CENTER)

        val sideBarPanel = JPanel(GridLayout(10, 1))
        setupButton(sideBarPanel)
        add(sideBarPanel, BorderLayout.WEST)

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
