package com.material.mvvm.structures.utils.bindingUtils

import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView.OnEditorActionListener
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

object EditTextBindingUtils {

    private const val ERROR_MESSAGE = "errorMessage"
    private const val EDIT_TEXT_FOCUS = "editTextFocus"
    private const val EDIT_TEXT_CLICK_LISTENER = "editTextClickListener"
    private const val ON_EDITOR_ACTION_LISTENER = "onEditorActionListener"
    private const val END_ICON_CLICK_LISTENER = "endIconClickListenerTextInputLayout"

    @JvmStatic
    @BindingAdapter(ERROR_MESSAGE)
    fun setTextInputLayoutErrorMessage(textInputLayout: TextInputLayout, errorMessage: String?) {
        if (!TextUtils.isEmpty(errorMessage)) {
            textInputLayout.error = errorMessage
        } else {
            textInputLayout.error = ""
        }
    }

    @JvmStatic
    @BindingAdapter(EDIT_TEXT_FOCUS)
    fun editTextFocus(editText: EditText, isFocus: Boolean) {
        editText.isFocusable = isFocus
    }

    @JvmStatic
    @BindingAdapter(EDIT_TEXT_CLICK_LISTENER)
    fun editTextClickListener(editText: EditText, onClickListener: View.OnClickListener?) {
        editText.setOnClickListener(onClickListener)
    }

    @JvmStatic
    @BindingAdapter(ON_EDITOR_ACTION_LISTENER)
    fun onEditorActionListener(
        editText: EditText,
        onEditorActionListener: OnEditorActionListener?
    ) {
        editText.setOnEditorActionListener(onEditorActionListener)
    }

    @JvmStatic
    @BindingAdapter(END_ICON_CLICK_LISTENER)
    fun endIconClickListener(
        textInputLayout: TextInputLayout,
        onClickListener: View.OnClickListener?
    ) {
        textInputLayout.setEndIconOnClickListener(onClickListener)
    }
}