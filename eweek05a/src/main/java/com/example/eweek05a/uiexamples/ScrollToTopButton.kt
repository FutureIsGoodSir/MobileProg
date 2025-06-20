package com.example.week05.uiexamples

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScrollToTopButton(goToTop: () -> Unit) {//스크롤을 상단으로 이동시키는 버튼
    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(//띄워져 있는 것처럼 보이는 버튼
            modifier = Modifier
                .padding(16.dp)
                .size(50.dp)
                .align(Alignment.BottomEnd),
            onClick = goToTop
        ) {
            Icon(
                Icons.Default.Home,
                contentDescription = "go to top"
            )
        }
    }
}

//@Composable
//fun ScrollToTopButton(goToTop: () -> Unit) {
//    Box(modifier = Modifier.fillMaxSize()) {
//        OutlinedButton(
//            onClick = goToTop,
//            border = BorderStroke(1.dp, Color.Gray),
//            shape = RoundedCornerShape(50),
//            colors = ButtonDefaults.outlinedButtonColors(
//                contentColor = Color.DarkGray
//            ),
//            modifier = Modifier.padding(5.dp).align(Alignment.BottomEnd)
//        ) {
//            Icon(
//                Icons.Default.Home,
//                contentDescription = "go to top"
//            )
//        }
//    }
//}

@Preview
@Composable
private fun ScrollToTopButtonPreview() {
    ScrollToTopButton({})
}