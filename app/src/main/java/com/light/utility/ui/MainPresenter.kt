package com.light.utility.ui

import com.light.utility.domain.TextUtilComponent
import com.light.utility.domain.UtilComponent

class MainPresenter constructor(
    override val view: MainContract.View
) : MainContract.Presenter {
    private val utils by lazy {
        mutableListOf<UtilComponent>()
    }

    override fun addList(component: UtilComponent) {
        utils.add(component)
    }

    override fun onUserEdited(text: String) {
        utils
            .filterIsInstance(TextUtilComponent::class.java)
            .forEach {
                it.apply(text)
            }
    }
}
