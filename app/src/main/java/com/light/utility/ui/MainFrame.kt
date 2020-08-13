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

    val utils by lazy {
        mutableListOf<UtilComponent>()
    }

    init {
        setupView()
        setupEventListeners()
    }

    private fun setupButton(sideBarPanel: JPanel) {
        sideBarPanel.add(
            UtilToggleButtonFactory().createToggleButton(
                UnicodeToBinaryEncoderComponent::class
            ).apply {
                addCommonUtilToggleButtonAction(UnicodeToBinaryEncoderComponent::class, UnicodeToBinaryEncoderFrame::class, utils)
            }
        )
        sideBarPanel.add(
            UtilToggleButtonFactory().createToggleButton(
                Base64EncoderComponent::class
            ).apply {
                addCommonUtilToggleButtonAction(Base64EncoderComponent::class, Base64EncoderFrame::class, utils)
            }
        )
        sideBarPanel.add(
            UtilToggleButtonFactory().createToggleButton(
                Base64DecoderComponent::class
            ).apply {
                addCommonUtilToggleButtonAction(Base64DecoderComponent::class, Base64DecoderFrame::class, utils)
            }
        )
        sideBarPanel.add(
            UtilToggleButtonFactory().createToggleButton(
                HexEncoderComponent::class
            ).apply {
                addCommonUtilToggleButtonAction(HexEncoderComponent::class, HexEncoderFrame::class, utils)
            }
        )
        sideBarPanel.add(
            UtilToggleButtonFactory().createToggleButton(
                HexDecoderComponent::class
            ).apply {
                addCommonUtilToggleButtonAction(HexDecoderComponent::class, HexDecoderFrame::class, utils)
            }
        )
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
