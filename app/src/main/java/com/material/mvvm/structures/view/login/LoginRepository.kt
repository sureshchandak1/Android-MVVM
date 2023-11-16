package com.material.mvvm.structures.view.login

import android.app.Activity
import android.text.Layout
import android.text.SpannableStringBuilder
import android.text.TextUtils
import android.text.style.AlignmentSpan
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.text.bold
import androidx.core.text.color
import androidx.core.text.inSpans
import androidx.core.text.scale
import androidx.core.text.underline
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.material.mvvm.structures.R
import com.material.mvvm.structures.utils.RegexController

class LoginRepository(private val mActivity: Activity) {

    @JvmField
    val email = ObservableField("suresh.chandak@gmail.com") // suresh.test@gmail.com
    @JvmField
    val errorEmail = ObservableField<String>()

    @JvmField
    val pass = ObservableField("12345678") // 12345678
    @JvmField
    val errorPass = ObservableField<String>()

    @JvmField
    val footerText = ObservableField<SpannableStringBuilder>()

    init {
        val builder = SpannableStringBuilder()
        builder.inSpans(AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER)) {
            color(ContextCompat.getColor(mActivity, R.color.grey_500)) { append("Not a member yet?  ") }
            bold { underline { color(ContextCompat.getColor(mActivity, R.color.onBackground)) { scale(1.2F) { append("Register now") } } } }
        }

        footerText.set(builder)
    }

    init {
        val onPropertyChangedCallback: Observable.OnPropertyChangedCallback =
            object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable, propertyId: Int) {
                    if (sender === email && RegexController.isValidEmailId(email.get())) {
                        errorEmail.set("")
                    } else if (sender === pass && !TextUtils.isEmpty(pass.get())) {
                        errorPass.set("")
                    }
                }
            }
        email.addOnPropertyChangedCallback(onPropertyChangedCallback)
        pass.addOnPropertyChangedCallback(onPropertyChangedCallback)
    }

    fun registerNowClick(view: View) {

    }

    internal fun validation(): Boolean {
        val validUserId: Boolean = RegexController.isValidEmailId(email.get())
        val validPass: Boolean = !TextUtils.isEmpty(pass.get())

        if (validUserId && validPass) {
            return true
        } else {
            if (!validUserId) {
                errorEmail.set("Please enter valid email")
            }
            if (!validPass) {
                errorPass.set("Please enter valid password")
            }
        }
        return false
    }

}