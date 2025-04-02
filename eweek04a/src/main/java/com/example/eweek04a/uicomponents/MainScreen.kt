package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek04a.model.TodoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember {
//        mutableStateListOf<Item>()
        TodoItemFactory.makeTodoList()
    }
    Column {
        TodoListTitle()
        TodoList(todoList)
//        Spacer(Modifier.height(80.dp))
        TodoItemInput(todoList)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}