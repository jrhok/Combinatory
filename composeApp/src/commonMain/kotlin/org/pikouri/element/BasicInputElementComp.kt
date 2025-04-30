package org.pikouri.element

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.pikouri.resource.Color
import org.pikouri.resource.Dimen

@Composable
fun BasicInputElementComp(
    modifier: Modifier = Modifier,
    element: BasicInputElement,
    onToggleState: () -> Unit,
) {
    val state by rememberSaveable(element.state) { mutableStateOf(element.state) }
    val textColor = if (element.state) Color.TRUE_ELEMENT_TEXT_COLOR else Color.FALSE_ELEMENT_TEXT_COLOR
    val color = if (element.state) Color.TRUE_ELEMENT_COLOR else Color.FALSE_ELEMENT_COLOR
    val stateText = state.stateToText()
    Row(modifier = modifier) {
        Box(
            modifier = Modifier
                .size(Dimen.BASIC_INPUT_ELEMENT_SIZE.dp)
                .clip(CircleShape)
                .border(
                    width = Dimen.ELEMENT_BORDER_WIDTH.dp,
                    color = Color.ELEMENT_BORDER_COLOR,
                    shape = CircleShape,
                )
                .background(color = color)
                .clickable{ onToggleState() },
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = stateText,
                color = textColor,
            )
        }
    }
}
