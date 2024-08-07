package com.binayshaw7777.kotstepapp.util

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.binayshaw7777.kotstepapp.R

object Constants  {

    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )

    val NOTO_SANS = GoogleFont("Noto Sans")

    val NOTO_SANS_FONT_FAMILY = FontFamily(
        Font(googleFont = NOTO_SANS, fontProvider = provider)
    )

    val ROBOTO = GoogleFont("Roboto")

    val ROBOTO_FONT_FAMILY = FontFamily(
        Font(googleFont = NOTO_SANS, fontProvider = provider)
    )
}