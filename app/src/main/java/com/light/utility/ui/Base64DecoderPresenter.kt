package com.light.utility.ui

import com.light.utility.domain.TextUtilComponent

class Base64DecoderPresenter constructor(
    override val view: Base64DecoderContract.View,
    component: TextUtilComponent
) : Base64DecoderContract.Presenter {
    override fun onUserEdited(text: String) {

    }
}
