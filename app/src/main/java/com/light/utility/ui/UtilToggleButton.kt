package com.light.utility.ui

import com.light.utility.domain.UtilComponent
import javax.swing.JFrame
import javax.swing.JToggleButton

class UtilToggleButton constructor(
    frameFactory: UtilFrameFactory,
    component: UtilComponent
) : JToggleButton(component.getName()) {

    private lateinit var frame: JFrame

    init {
        addActionListener {
            if (isSelected) {
                if (!::frame.isInitialized) {
                    frame = frameFactory.create(component)
                }
                frame.isVisible = true
            } else {
                frame.dispose()
            }
        }
    }
}
