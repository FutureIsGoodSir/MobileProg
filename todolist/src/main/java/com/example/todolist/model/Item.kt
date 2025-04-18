package com.example.todolist.model

class Item(
    val content: String,
    val time:String,
    val status: TodoStatus = TodoStatus.PENDING
)