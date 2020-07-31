package com.light.utility.ui

import com.light.utility.BasePresenter
import com.light.utility.BaseView

interface DecoderContract {
    interface DecoderView: BaseView<DecoderPresenter> {
        fun showValidationFailed()
        fun showEncodingFailed()
        fun showSuccessfullyEncoded()
    }

    interface DecoderPresenter: BasePresenter {
        fun onUserEdited(text: String)
    }
}
