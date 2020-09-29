package com.light.utility.ui

interface Base64DecoderContract {
    interface View {
        val presenter: Presenter
        fun showValidationFailed()
        fun showEncodingFailed()
        fun showSuccessfullyEncoded(text: String)
    }

    interface Presenter {
        val view: View
        fun onUserEdited(text: String)
    }
}
