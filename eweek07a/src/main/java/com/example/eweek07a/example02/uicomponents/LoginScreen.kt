package com.example.eweek07a.example02.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(onWelcomeNavigate:(String)->Unit,onRegisterNavigate:(String,String)->Unit) {

    val userId = "greenjoa"
    val userPasswd = "1234"

    var userIdState by remember {
        mutableStateOf("")
    }

    var userPasswdState by remember {
        mutableStateOf("")
    }

    val loginresult by remember {
        derivedStateOf { userId == userIdState && userPasswd == userPasswdState }
    }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text="Login Screen",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold)

        OutlinedTextField(value = userIdState,//테두리 있는 텍스트 필드
            onValueChange = {userIdState =it},
            label = {Text("User ID")}
        )

        OutlinedTextField( value = userPasswdState,
            onValueChange = { userPasswdState = it },
            label = { Text("Enter password") },
            visualTransformation = PasswordVisualTransformation(),//비밀번호/암호/패스워드/비번을 가려 줌
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(onClick = {
            if(loginresult)
                onWelcomeNavigate(userIdState)
            else
                onRegisterNavigate(userIdState,userPasswdState)
        }){
            Text(text = "Login")
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        onWelcomeNavigate = {},
        onRegisterNavigate = {a,b->}
    )
}