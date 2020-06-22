package com.light.utility

import java.awt.Toolkit
import javax.swing.JFrame

class MainFrame : JFrame() {

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        size = Toolkit.getDefaultToolkit().screenSize
        isVisible = true
    }
}