package com.example.instagramclone.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.instagramclone.R

val InstagramFont = FontFamily(Font(R.font.billabong))

fun typography(colorScheme: ColorScheme): Typography {
    return Typography(
        bodyLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = fontSmall,
            color = colorScheme.onBackground
        ),
        headlineLarge = TextStyle(
            fontFamily = InstagramFont,
            fontWeight = FontWeight.Normal,
            fontSize = fontXXLarge,
            color = colorScheme.onBackground
        )
    )
}

