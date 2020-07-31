package com.light.utility.ui

import com.light.utility.BasePresenter
import com.light.utility.BaseView

interface EncoderContract {
    interface View: BaseView<Presenter> {
        fun showValidationFailed()
        fun showEncodingFailed()
        fun showSuccessfullyEncoded()
    }

    interface Presenter: BasePresenter {
        fun onUserEdited(text: String)
    }
}
