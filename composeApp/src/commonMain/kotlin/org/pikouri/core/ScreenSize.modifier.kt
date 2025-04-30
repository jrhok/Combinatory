package org.pikouri.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.IntSize
import kotlin.math.roundToInt

@Composable
expect fun getScreenSize(): DpSize

@Composable
fun getScreenSizePx() = with(LocalDensity.current) {
    getScreenSize().run {
        IntSize(
            width = width.toPx().roundToInt(),
            height = height.toPx().roundToInt(),
        )
    }
}

