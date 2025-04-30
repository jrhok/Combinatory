package org.pikouri.element

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ElementComp(
    element: Element,
    modifier: Modifier = Modifier,
    onToggleBasicInputElementState: (BasicInputElement) -> Unit,
) = when (element) {
    is BasicInputElement -> {
        BasicInputElementComp(
            element = element,
            modifier = modifier,
            onToggleState = { onToggleBasicInputElementState(element) })
    }
}
