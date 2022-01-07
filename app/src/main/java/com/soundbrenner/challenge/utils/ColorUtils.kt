package com.soundbrenner.challenge.utils

import android.graphics.Color

fun setColorAlpha(argb: Int, alpha: Int) = Color.argb(
    alpha,
    Color.red(argb),
    Color.green(argb),
    Color.blue(argb)
)
