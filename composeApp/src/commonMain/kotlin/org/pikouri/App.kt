package org.pikouri

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.pikouri.common.fab.AddElementFloatingActionButton
import org.pikouri.element.Element

@Composable
@Preview
fun App() = MaterialTheme {
    val elements = remember { mutableStateListOf<Element>() }
    Scaffold(
        floatingActionButton = {
            AddElementFloatingActionButton(onAdd = { element ->
                elements.add(element)
            })
        },
    ) { innerPadding ->
        MainCanvas(
            modifier = Modifier.padding(innerPadding),
            elements = elements,
        )
    }
}
