package com.light.utility.ui

import com.light.utility.domain.TextUtilComponent
import com.light.utility.domain.UtilComponent
import javax.swing.JFrame
import javax.swing.JToggleButton
import kotlin.reflect.KClass

class UtilToggleButton(buttonName: String) : JToggleButton(buttonName) {

    private val utilButtonName: String = buttonName

    fun getButtonName(): String { return utilButtonName }

    fun addCommonUtilToggleButtonAction(componentClass: KClass<*>, frameClass: KClass<*>, componentList: MutableList<UtilComponent>) {
        lateinit var frame: Any
        this.addActionListener {
            if (this.isSelected) {
                val component = componentClass.java.newInstance().also { componentList.add(it as UtilComponent) }
                frame = frameClass.java.getConstructor(TextUtilComponent::class.java).newInstance(component as UtilComponent)
            } else {
                componentList.removeIf { it == componentClass }
                (frame as JFrame).dispose()
            }
        }
    }
}
