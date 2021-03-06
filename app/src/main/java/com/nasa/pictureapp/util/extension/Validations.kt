package com.nasa.pictureapp.util.extension

import androidx.core.util.PatternsCompat

fun String.isEmailAddressValid(): Boolean {
    return this.trim().isNotEmpty() && PatternsCompat.EMAIL_ADDRESS.matcher(this).matches()
}