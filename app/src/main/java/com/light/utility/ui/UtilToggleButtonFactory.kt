package com.light.utility.ui
import kotlin.reflect.KClass

class UtilToggleButtonFactory {

    fun createToggleButton(componentClass: KClass<*>): UtilToggleButton {
        return UtilToggleButton(resolveButtonName(componentClass))
    }

    private fun resolveButtonName(componentClass: KClass<*>): String {
        return componentClass.simpleName.toString().replace("Component", "")
    }
}
