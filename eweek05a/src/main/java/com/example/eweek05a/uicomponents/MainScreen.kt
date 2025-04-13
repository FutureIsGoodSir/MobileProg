package com.example.eweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eweek05a.viewmodel.ImageViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {

    val imageList = imageViewModel.imageList
    val scrollState = rememberScrollState()
    val orientation = LocalConfiguration.current.orientation
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(
            Modifier.fillMaxWidth().verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageList(imageList = imageList)
        }
    } else {
        Row(
            Modifier.fillMaxHeight().horizontalScroll(scrollState),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageList(imageList = imageList)
        }
    }

//    var img1State by rememberSaveable(stateSaver = ImageData.ImageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img1),
//                buttonType = ButtonType.BADGE,
//                likes = 50
//            )
//        )
//    }
//    var img2State by rememberSaveable(stateSaver = ImageData.ImageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img2),
//                buttonType = ButtonType.EMOJI,
//                likes = 100,
//                dislikes = 10
//            )
//        )
//    }
//
//    Column {
//        ImageWithButton(image = img1State.image) {
//            ButtonWithBadge(
//                likes = img1State.likes
//            ) {
//                img1State = img1State.copy(likes = img1State.likes + 1)//++로하면 변경이 되지 않는 이뮤터블이기 때문에
//            }
//        }
//
//        ImageWithButton(image = img2State.image) {
//            ButtonWithEmoji(
//                likes = img2State.likes,
//                dislikes = img2State.dislikes,
//                onClickLikes = { img2State = img2State.copy(likes = img2State.likes + 1) },
//                onClickDisLikes = { img2State = img2State.copy(dislikes = img2State.dislikes + 1) }
//            )
//        }
//    }
//
////    Column {
////        when (img1State.image) {
////            is ImageUri.WebImage -> AsyncImage(
////                model = (img1State.image as ImageUri.WebImage).webUrl,
////                contentDescription = null
////            )
////
////            is ImageUri.ResImage -> Image(
////                painter = painterResource((img1State.image as ImageUri.ResImage).resID),
////                contentDescription = null
////            )
////
////            else -> throw IllegalArgumentException("타입 오류")
////        }
////
////        Button(
////            {
////                img1State = ImageData(
////                    image = ImageUri.ResImage(R.drawable.img2),
////                    buttonType = ButtonType.ICON,
////                    likes = 23,
////                    dislikes = 14
////                )
////            }
////        ) {
////
////        }
////    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}