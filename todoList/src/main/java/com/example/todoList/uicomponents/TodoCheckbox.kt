package com.example.todoList.uicomponents

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TodoCheckbox(
    checked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit
) {
    Checkbox(
        checked=checked,
        onCheckedChange = {checked -> onCheckedChange(checked)}//상태 값을 밖으로 전달하자
    )
}

//@Composable
//fun TodoCheckbox(
//    checked: Boolean,
//    onCheckedChange:(Boolean)->Unit
//) {
//    Checkbox(
//        checked,
//        onCheckedChange = {onCheckedChange(it)}
//    )
//}