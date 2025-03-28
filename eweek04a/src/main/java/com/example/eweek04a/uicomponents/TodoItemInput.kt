package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoItemFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TodoItemInput(todoList:MutableList<Item>, modifier: Modifier = Modifier) {
    //텍스트 필드는 연결된 상태 객체?가 필요
    var textFieldState by remember { mutableStateOf("") }
    Row {
        TextField(
            value = textFieldState,//스테이트가 바뀌면 함수가 재호출해야 되니까, 컨텐츠 내용이 여기 들어가야 함
            onValueChange = {text:String->textFieldState = text},//꼭 줘야 한다, 텍스트로 입력 값이 들어온다
            placeholder = {Text("할 일을 입력하세요.")}
        )
        Button(onClick = {
            //내가 완성
            todoList.add(Item(content = textFieldState,time = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("MM-dd HH:mm"))))
        }) {
            Text("추가")
//            Spacer(Modifier.width())
        }
    }
}

@Preview
@Composable
private fun TodoItemInputPreview() {
    TodoItemInput(TodoItemFactory.makeTodoList())
}