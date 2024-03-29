package com.light.utility.ui

import com.light.utility.domain.TextUtilComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.awt.Dimension
import java.awt.Point
import java.awt.Toolkit
import javax.swing.JFrame
import javax.swing.JTextArea

class HexEncoderFrame constructor(
    private val component: TextUtilComponent
) : JFrame() {
    private val textArea by lazy {
        JTextArea()
    }

    init {
        setupView()
        subscribeEventStream()
    }

    private fun setupView() {
        defaultCloseOperation = EXIT_ON_CLOSE
        val screenSize = Toolkit.getDefaultToolkit().screenSize
        size = Dimension(screenSize.width / 2, screenSize.height / 2)
        location = Point(screenSize.width / 2, screenSize.height / 4)
        add(textArea)
        isVisible = true
    }

    private fun subscribeEventStream() {
        GlobalScope.launch(Dispatchers.IO) {
            component.getState().collect {
                textArea.text = it
            }
        }
    }
}
