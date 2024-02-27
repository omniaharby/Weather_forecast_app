package com.example.weatherforecast.domain

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.palette.graphics.Palette

fun extractColorsFromResource(
    context: Context,
    resourceId: Int,
    onColorsExtracted: (Map<String, Color>) -> Unit
) {
    val bitmap = BitmapFactory.decodeResource(context.resources, resourceId)
    Palette.from(bitmap).generate { palette ->
        val colors = mutableMapOf<String, Color>()
        palette?.let {
            colors.put(
                COLOR_KEY_VIBRANT,
                Color(palette.getVibrantColor(Color.White.toArgb()))
            )
            colors.put(
                COLOR_KEY_MUTED,
                Color(palette.getMutedColor(Color.Black.toArgb()))
            )
            colors.put(
                COLOR_KEY_VIBRANT_LIGHT,
                Color(palette.getLightVibrantColor(Color.Black.toArgb()))
            )
            colors.put(
                COLOR_KEY_Vibrant_DARK,
                Color(palette.getDarkVibrantColor(Color.Black.toArgb()))
            )
            colors.put(
                COLOR_KEY_MUTED_DARK,
                Color(palette.getDarkMutedColor(Color.Black.toArgb()))
            )
            colors.put(
                COLOR_KEY_MUTED_LIGHT,
                Color(palette.getLightMutedColor(Color.Black.toArgb()))
            )
        }
        onColorsExtracted(colors)
    }
}

const val COLOR_KEY_VIBRANT = "vibrant"
const val COLOR_KEY_Vibrant_DARK = "vibrant dark"
const val COLOR_KEY_VIBRANT_LIGHT = "vibrant light"
const val COLOR_KEY_MUTED = "muted"
const val COLOR_KEY_MUTED_DARK = "muted dark"
const val COLOR_KEY_MUTED_LIGHT = "muted light"
