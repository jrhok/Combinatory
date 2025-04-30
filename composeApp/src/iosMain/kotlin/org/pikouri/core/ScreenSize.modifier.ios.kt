package org.pikouri.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import platform.UIKit.UIScreen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun getScreenSize(): DpSize = LocalWindowInfo.current.containerSize.run {
    DpSize(
        width = width.pxToPoint().dp,
        height = height.pxToPoint().dp
    )
}

fun Int.pxToPoint(): Double = this.toDouble() / UIScreen.mainScreen.scale
