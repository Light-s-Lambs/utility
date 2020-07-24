package com.light.utility.ui
import com.light.utility.domain.Base64DecoderComponent
import com.light.utility.domain.Base64EncoderComponent
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
import javax.swing.JToggleButton

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

    private fun setupButton(pan: JPanel) {

        val u2beBtn = JToggleButton("U2B Encoder")
        val b64eBtn = JToggleButton("Base64 Encoder")
        val b64dBtn = JToggleButton("Base64 Decoder")

        lateinit var u2beFrame: UnicodeToBinaryEncoderFrame
        lateinit var b64eFrame: Base64EncoderFrame
        lateinit var b64dFrame: Base64DecoderFrame

        u2beBtn.addActionListener {
            var notInitialized = true
            utils.filterIsInstance(UnicodeToBinaryEncoderComponent::class.java).forEach {
                utils.remove(it)
                notInitialized = false
                u2beFrame.endFrame()
            }
            if (notInitialized) {
                val binaryEncoderComponent = UnicodeToBinaryEncoderComponent().also { utils.add(it) }
                u2beFrame = UnicodeToBinaryEncoderFrame(binaryEncoderComponent)
            }
        }

        b64eBtn.addActionListener {
            var notInitialized = true
            utils.filterIsInstance(Base64EncoderComponent::class.java).forEach {
                utils.remove(it)
                notInitialized = false
                b64eFrame.endFrame()
            }
            if (notInitialized) {
                val base64EncoderComponent = Base64EncoderComponent().also { utils.add(it) }
                b64eFrame = Base64EncoderFrame(base64EncoderComponent)
            }
        }

        b64dBtn.addActionListener {
            var notInitialized = true
            utils.filterIsInstance(Base64DecoderComponent::class.java).forEach {
                utils.remove(it)
                notInitialized = false
                b64dFrame.endFrame()
            }
            if (notInitialized) {
                val base64DecoderComponent = Base64DecoderComponent().also { utils.add(it) }
                b64dFrame = Base64DecoderFrame(base64DecoderComponent)
            }
        }

        pan.add(u2beBtn)
        pan.add(b64eBtn)
        pan.add(b64dBtn)
    }

    private fun setupView() {
        defaultCloseOperation = EXIT_ON_CLOSE
        val screenSize = Toolkit.getDefaultToolkit().screenSize
        size = Dimension(screenSize.width / 2, screenSize.height / 2)
        layout = BorderLayout()
        add(textArea, BorderLayout.CENTER)

        val pan = JPanel(GridLayout(10, 1))
        setupButton(pan)
        add(pan, BorderLayout.WEST)

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
