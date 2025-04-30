package org.pikouri.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Composable
actual fun getScreenSize(): DpSize = LocalConfiguration.current.run {
    DpSize(
        width = screenWidthDp.dp,
        height = screenHeightDp.dp
    )
}
