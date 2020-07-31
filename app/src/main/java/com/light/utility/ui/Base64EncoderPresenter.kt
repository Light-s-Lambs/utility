package com.light.utility.ui

class Base64EncoderPresenter constructor(
    private val view: EncoderContract.View
) : EncoderContract.Presenter {
    override fun onUserEdited(text: String) {
    }

}
