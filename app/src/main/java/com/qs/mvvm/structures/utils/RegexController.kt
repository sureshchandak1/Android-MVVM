package com.qs.mvvm.structures.utils

import android.text.TextUtils
import java.util.regex.Pattern

class RegexController private constructor() {

    init {
        throw IllegalStateException(javaClass.name)
    }

    companion object {

        @JvmStatic
        fun isValidUserId(s: String?): Boolean {
            val userIdRegex = "[a-zA-Z0-9_.@]{4,50}"
            val userIdPattern = Pattern.compile(userIdRegex)
            return !TextUtils.isEmpty(s) && userIdPattern.matcher(s!!).matches()
        }

        @JvmStatic
        fun isValidEmailId(s: String?): Boolean {
            val userIdRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            val userIdPattern = Pattern.compile(userIdRegex)
            return !TextUtils.isEmpty(s) && userIdPattern.matcher(s!!).matches()
        }

        @JvmStatic
        fun isValidPassword(s: String?): Boolean {
            /*
                Minimum 8 and maximum 10 characters, at least one uppercase letter,
                one lowercase letter, one number and one special character:
            */
            val pasRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$"
            val passwordPattern = Pattern.compile(pasRegex)
            return !TextUtils.isEmpty(s) && passwordPattern.matcher(s!!).matches()
        }

        @JvmStatic
        fun isValidName(s: String?): Boolean {

            if (TextUtils.isEmpty(s)) {
                return false
            }
            if (s!!.trim().length < 2) {
                return false
            }

            var p = Pattern.compile("^[a-zA-Z]*$", Pattern.CASE_INSENSITIVE)
            var m = p.matcher(s)
            val noSpecialCharacter = m.find()

            p = Pattern.compile("([0-9]|[aA-zZ])\\1\\1", Pattern.CASE_INSENSITIVE)
            m = p.matcher(s)
            val isConsecutiveIdentical = m.find()

            return noSpecialCharacter && !isConsecutiveIdentical
        }

        @JvmStatic
        fun isValidMobileNumber(s: String?): Boolean {
            val userIdRegex = "([+])?[1-9][0-9]{9,14}"
            val userIdPattern = Pattern.compile(userIdRegex)
            return !TextUtils.isEmpty(s) && userIdPattern.matcher(s!!).matches()
        }

    }
}