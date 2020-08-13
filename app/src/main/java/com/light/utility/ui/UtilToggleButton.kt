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
                frame = frameFactory.create(component)
            } else {
                frame.dispose()
            }
        }
    }
}
