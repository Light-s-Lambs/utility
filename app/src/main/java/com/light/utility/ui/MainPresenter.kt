package com.light.utility.ui

import com.light.utility.BasePresenter

class MainPresenter : MainContract.Presenter {

    val view = MainFrame(this)

    override fun onUserEdited(text: String) {
        utils
            .filterIsInstance(EncoderContract.Presenter::class.java)
            .forEach {
                it.onUserEdited(text)
            }
    }

    private val utils by lazy {
        mutableListOf<BasePresenter>()
    }

    init {
        UnicodeToBinaryEncoderPresenter().also { utils.add(it) }
        Base64EncoderPresenter().also { utils.add(it) }
        Base64DecoderPresenter().also { utils.add(it) }
    }
}
