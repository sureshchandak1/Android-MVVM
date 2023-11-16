package com.qs.mvvm.structures.utils.bindingUtils

import android.text.SpannableStringBuilder
import android.text.TextUtils
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.BindingAdapter
import com.google.android.material.chip.Chip

object ChipBindingUtil {

    private const val SET_CHIP_BACKGROUND_COLOR = "setChipBackgroundColor"
    private const val SET_CHIP_SPANNABLE_STRING = "setChipSpannableString"

    @JvmStatic
    @BindingAdapter(SET_CHIP_BACKGROUND_COLOR)
    fun setChipBackgroundColor(chip: Chip, color: Int) {
        chip.chipBackgroundColor = AppCompatResources.getColorStateList(chip.context, color)
    }

    @JvmStatic
    @BindingAdapter(SET_CHIP_SPANNABLE_STRING)
    fun setChipSpannableString(
        chip: Chip,
        spannableStringBuilder: SpannableStringBuilder?
    ) {
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            chip.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE)
        }
    }
}