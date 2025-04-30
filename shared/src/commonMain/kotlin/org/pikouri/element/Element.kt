package org.pikouri.element

sealed class Element

sealed class InputElement(open var state: Boolean): Element()

fun Boolean.stateToText() = if (this) "1" else "0"
