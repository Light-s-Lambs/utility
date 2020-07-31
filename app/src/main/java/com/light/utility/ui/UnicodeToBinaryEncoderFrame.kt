package com.light.utility.ui

import java.awt.Dimension
import java.awt.Point
import java.awt.Toolkit
import javax.swing.JFrame
import javax.swing.JTextArea

class UnicodeToBinaryEncoderFrame constructor(
    override val presenter: EncoderContract.Presenter
) : EncoderContract.View, JFrame() {
    private val textArea by lazy {
        JTextArea()
    }

    companion object {
        private const val INVALID_INPUT_MESSAGE = "Check your Input"
        private const val ENCODING_FAIL_MESSAGE = "Encoding failed!"
    }

    init {
        setupView()
    }

    private fun setupView() {
        defaultCloseOperation = EXIT_ON_CLOSE
        val screenSize = Toolkit.getDefaultToolkit().screenSize
        size = Dimension(screenSize.width / 2, screenSize.height / 2)
        location = Point(screenSize.width / 2, screenSize.height / 2)
        add(textArea)
        isVisible = true
    }

    override fun showValidationFailed() {
        textArea.text = INVALID_INPUT_MESSAGE
    }
    override fun showEncodingFailed() {
        textArea.text = ENCODING_FAIL_MESSAGE
    }
    override fun showSuccessfullyEncoded(text: String) {
        textArea.text = text
    }
}
