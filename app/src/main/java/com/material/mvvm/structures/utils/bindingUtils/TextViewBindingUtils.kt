package com.material.mvvm.structures.utils.bindingUtils

import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.text.SpannableStringBuilder
import android.text.TextUtils
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter


object TextViewBindingUtils {

    private const val SET_TEXT_SPANNABLE_STRING = "setTextSpannableString"
    private const val SET_TEXTVIEW_DRAWABLE_START = "setTextViewDrawableStart"
    private const val SET_UNDERLINE_TEXT = "underlineText"
    private const val SET_CENTER_UNDERLINE_TEXT = "centerUnderlineText"
    private const val SET_DRAWABLE_TINE = "setDrawableTint"

    @JvmStatic
    @BindingAdapter(SET_TEXT_SPANNABLE_STRING)
    fun setTextSpannableString(
        textView: TextView,
        spannableStringBuilder: SpannableStringBuilder?
    ) {
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE)
        }
    }

    @BindingAdapter(SET_TEXTVIEW_DRAWABLE_START)
    fun setTextViewDrawableStart(textView: TextView, drawable: Drawable?) {
        if (drawable != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
        }
    }

    @JvmStatic
    @BindingAdapter(SET_UNDERLINE_TEXT)
    fun underlineText(
        textView: TextView,
        text: String?
    ) {
        if (!TextUtils.isEmpty(text)) {
            textView.paintFlags = textView.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            textView.text = text
        }
    }

    @JvmStatic
    @BindingAdapter(SET_CENTER_UNDERLINE_TEXT)
    fun centerUnderlineText(
        textView: TextView,
        text: String?
    ) {
        if (!TextUtils.isEmpty(text)) {
            textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            textView.text = text
        }
    }

    @BindingAdapter(SET_DRAWABLE_TINE)
    fun setDrawableTint(textView: TextView, color: Int) {
        val drawables = textView.compoundDrawables
        for (drawable in drawables) {
            if (drawable != null) {
                drawable.colorFilter = PorterDuffColorFilter(
                    ContextCompat.getColor(textView.context, color),
                    PorterDuff.Mode.SRC_IN
                )
            }
        }
    }

}