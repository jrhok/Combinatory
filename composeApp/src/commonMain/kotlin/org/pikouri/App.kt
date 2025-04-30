package org.pikouri

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() = MaterialTheme {
    Scaffold { innerPadding ->
        MainCanvas(modifier = Modifier.padding(innerPadding))
    }
}
