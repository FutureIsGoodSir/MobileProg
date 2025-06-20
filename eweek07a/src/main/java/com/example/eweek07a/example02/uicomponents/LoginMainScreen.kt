package com.example.eweek07a.example02.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.eweek07a.example02.navGraph.LoginNavGraph

@Composable
fun LoginMainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()//네이게이션 컨트롤러도 리멤버 해 주어야 함
    LoginNavGraph(navController= navController)
}