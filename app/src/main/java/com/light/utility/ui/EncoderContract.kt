package com.light.utility.ui

import com.light.utility.BasePresenter
import com.light.utility.BaseView

interface EncoderContract {
    interface EncoderView: BaseView<EncoderPresenter> {
        fun showValidationFailed()
        fun showEncodingFailed()
        fun showSuccessfullyEncoded()
    }

    interface EncoderPresenter: BasePresenter {
        fun onUserEdited(text: String)
    }
}
