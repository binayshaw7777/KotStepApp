package com.binayshaw7777.kotstepapp.util

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

object Util {

    fun Context.openLink(url: String = "https://github.com/binayshaw7777/KotStep") {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = url.toUri()
        startActivity(intent)
    }

}