package com.example.eweek04a

import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoStatus
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TodoService(val todoList:MutableList<Item>) {

    fun addContent(content:String){
        val currentTime = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("MM 월 dd 일 HH 시 mm"))
        todoList.add(Item(content,currentTime))
    }

    fun markCompleted(index:Int){
        val memo = todoList.get(index)
            memo.status=TodoStatus.COMPLETED
        println("메모 완료 처리됨: $memo")
    }

    fun search(keyword:String){
        todoList.filter{it.content.contains(keyword)}.forEach{ println(it)}
    }

    fun listTodos(){
        if(todoList.isEmpty()){
            println("등록된 일정이 없습니다.")
        }else{
            println("전체메모")
            todoList.forEachIndexed { index, item ->
                println("$index : $item")
            }
        }
    }

}