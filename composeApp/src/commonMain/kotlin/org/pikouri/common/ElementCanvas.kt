package org.pikouri.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.draggable2D
import androidx.compose.foundation.gestures.rememberDraggable2DState
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.roundToInt

interface ElementCanvasScope {
    @Composable
    fun Modifier.draggableElement(
        startingXFraction: Float,
        startingYFraction: Float,
    ): Modifier

    @Composable
    fun Modifier.draggableElement(): Modifier = draggableElement(
        startingXFraction = 0f,
        startingYFraction = 0f,
    )
}

private val FRACTION_RANGE = 0f..1f

internal class ElementCanvasScopeInstance(
    canvasSize: IntSize
) : ElementCanvasScope {
    private val canvasWidth = canvasSize.width
    private val canvasHeight = canvasSize.height

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Modifier.draggableElement(
        startingXFraction: Float,
        startingYFraction: Float,
    ): Modifier {
        var offsetXFraction by remember { mutableStateOf(startingXFraction) }
        var offsetYFraction by remember { mutableStateOf(startingYFraction) }
        return this
            .then(
                offset {
                    IntOffset(
                        x = (offsetXFraction * canvasWidth).roundToInt(),
                        y = (offsetYFraction * canvasHeight).roundToInt()
                    )
                }
            ).then(
                draggable2D(
                    state = rememberDraggable2DState { delta ->
                        val newValueX = offsetXFraction + (delta.x / canvasWidth)
                        val newValueY = offsetYFraction + (delta.y / canvasHeight)
                        offsetXFraction = newValueX.coerceIn(FRACTION_RANGE)
                        offsetYFraction = newValueY.coerceIn(FRACTION_RANGE)
                    },
                )
            )
    }
}

@Composable
@Preview
fun ElementCanvas(
    modifier: Modifier = Modifier,
    content: @Composable ElementCanvasScope.() -> Unit
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Yellow),
    ) {
        val boxWithConstraintsScope = this
        with(LocalDensity.current) {
            val scope = remember(boxWithConstraintsScope) {
                ElementCanvasScopeInstance(
                    canvasSize = IntSize(
                        width = maxWidth.toPx().roundToInt(),
                        height = maxHeight.toPx().roundToInt()
                    ),
                )
            }
            scope.content()
        }
    }
}
