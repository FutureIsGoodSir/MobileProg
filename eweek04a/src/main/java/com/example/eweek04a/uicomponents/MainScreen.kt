package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eweek04a.model.TodoItemFactory
import com.example.eweek04a.model.TodoStatus

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember {
//        mutableStateListOf<Item>()
        TodoItemFactory.makeTodoList()
    }

    var showPending by remember { mutableStateOf(false) }
    val filteredList = if (showPending)
        todoList.filter { it.status == TodoStatus.PENDING }.toMutableList()
    else
        todoList
    Column {
        TodoListTitle()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("미완료 항목만 보기")
            Switch(
                showPending,
                onCheckedChange = {
                    showPending = it
                }
            )
        }
        TodoList(todoList, Modifier.weight(1f))
        Spacer(Modifier.height(80.dp))
        TodoItemInput(todoList)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}