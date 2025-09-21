package com.binayshaw7777.kotstepapp.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.binayshaw7777.kotstepapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val AtypFontFamily = FontFamily(
    Font(R.font.atyp_thin, FontWeight.Thin),
    Font(R.font.atyp_light, FontWeight.Light),
    Font(R.font.atyp_regular, FontWeight.Normal),
    Font(R.font.atyp_semi_bold, FontWeight.SemiBold),
    Font(R.font.atyp_medium, FontWeight.Medium),
    Font(R.font.atyp_bold, FontWeight.Bold)
)
