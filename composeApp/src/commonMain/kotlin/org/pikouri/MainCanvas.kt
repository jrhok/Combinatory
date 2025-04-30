package org.pikouri

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import combinatory.composeapp.generated.resources.Res
import combinatory.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.pikouri.common.ElementCanvas

@Composable
fun MainCanvas(modifier: Modifier = Modifier) = ElementCanvas(modifier) {
    var showContent by remember { mutableStateOf(false) }
    val greeting = remember { Greeting().greet() }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = { showContent = !showContent }) {
            Text("Click me!")
        }
        AnimatedVisibility(showContent) {
            Text("Compose: $greeting")
        }
    }
    AnimatedVisibility(showContent) {
        Image(
            painterResource(Res.drawable.compose_multiplatform),
            null,
            modifier = Modifier
                .fillMaxSize(1 / 10f)
                .draggableElement(
                    startingXFraction = 1 / 2f,
                    startingYFraction = 1 / 2f,
                )
        )
    }
}
