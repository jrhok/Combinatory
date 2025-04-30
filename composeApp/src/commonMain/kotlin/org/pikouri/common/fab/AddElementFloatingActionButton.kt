package org.pikouri.common.fab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import org.pikouri.resource.Dimen
import org.pikouri.element.BasicInputElement
import org.pikouri.element.Element

@Composable
fun AddElementFloatingActionButton(onAdd: (Element) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    fun addAndClose(element: Element) = onAdd(element).also { expanded = false }
    Column(
        verticalArrangement = Arrangement.spacedBy(Dimen.FLOATING_ACTION_BUTTON_MENU_VERTICAL_SPACED_BY.dp)
    ) {
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            DropdownMenuItem(onClick = { addAndClose(BasicInputElement()) }) { Text("Input") }
            DropdownMenuItem(onClick = {}) { Text("menu 2") }
            DropdownMenuItem(onClick = {}) { Text("menu 3") }
            DropdownMenuItem(onClick = {}) { Text("menu 4") }
        }
        FloatingActionButton(
            onClick = { expanded = !expanded },
        ) {
            Icon(Icons.Filled.Add, "Add element floating action button")
        }
    }
}
