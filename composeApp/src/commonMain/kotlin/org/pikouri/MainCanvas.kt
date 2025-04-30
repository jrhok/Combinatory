package org.pikouri

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import org.pikouri.common.ElementCanvas
import org.pikouri.element.Element
import org.pikouri.element.ElementComp

@Composable
fun MainCanvas(modifier: Modifier = Modifier, elements: SnapshotStateList<Element>) = ElementCanvas(modifier) {
    elements.mapIndexed { index, element ->
        ElementComp(
            element = element,
            modifier = Modifier
                .draggableElement(1 / 2f, 1 / 2f),
            onToggleBasicInputElementState = { basicInputElement ->
                elements[index] = basicInputElement.copy(state = !basicInputElement.state)
            }
        )
    }
}
