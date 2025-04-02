package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoStatus

@Composable
fun TodoList(
    todoList: MutableList<Item>,
    modifier: Modifier = Modifier,
    showPending: Boolean
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        todoList.forEachIndexed { index, item ->
            if ((showPending && item.status == TodoStatus.PENDING)
                || !showPending
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Row {
                        TodoCheckbox(item.status == TodoStatus.COMPLETED) { isChecked ->
                            todoList[index] = item.copy(
                                status = if (isChecked) TodoStatus.COMPLETED
                                else TodoStatus.PENDING
                            )
                        }
                        TodoItem(item = item)
                    }
                }
            }
        }
    }
}
//@Composable
//fun TodoList(todoList: MutableList<Item>, modifier: Modifier = Modifier) {
//    //rememberScrollState
//    Column(modifier) {
//        todoList.forEachIndexed { index, item ->
//            Card(
//                Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//                    .toggleable(
//                        item.status == TodoStatus.COMPLETED,
//                        role = Role.Checkbox,
//                        onValueChange = { isChecked ->
//                            todoList[index] = item.copy(
//                                status = if(isChecked)
//                                    TodoStatus.COMPLETED
//                                else
//                                    TodoStatus.PENDING
//                            )
//                        },
//
//                    )
//            ) {
//                Row {
//                    TodoCheckbox(item.status == TodoStatus.COMPLETED) { isChecked ->
//                        todoList[index] = item.copy(
//                            status = if(isChecked)
//                                 TodoStatus.COMPLETED
//                            else
//                                TodoStatus.PENDING
//                        )
//                    }
//                    Column(Modifier.padding(4.dp)) {
//                        TodoItem(item)
//                    }
//                }
//            }
//        }
//    }
//}

@Preview
@Composable
private fun TodoListPreview() {
//    TodoList(TodoItemFactory.makeTodoList())
}