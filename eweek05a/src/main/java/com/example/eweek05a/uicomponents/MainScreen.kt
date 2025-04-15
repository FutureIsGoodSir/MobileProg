package com.example.eweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek05a.model.ImageListFactory
import com.example.week05.uiexamples.ScrollToTopButton
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
//    imageViewModel: ImageViewModel = viewModel()
) {
    val orientation = LocalConfiguration.current.orientation
    val imageList = ImageListFactory.makeImageList()

    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf {
            state.firstVisibleItemIndex > 0
        }
    }

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Box(Modifier.fillMaxSize()) {
            LazyColumn(
                Modifier.fillMaxWidth(),
                state = state,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(imageList) { index, imageData ->
                    SingleImage(
                        imageData = imageData,
                        onClickLikes =
                            {
                                imageList[index] = imageData.copy(likes = imageData.likes + 1)
                            },
                        onClickDislikes =
                            {
                                imageList[index] = imageData.copy(dislikes = imageData.dislikes + 1)
                            },
                    )
                }
            }
            AnimatedVisibility(showButton) {
                ScrollToTopButton {
                    scope.launch {
                        state.scrollToItem(0)
                    }
                }
            }
        }
    } else {
        Box(Modifier.fillMaxSize()) {
            LazyColumn(
                Modifier.fillMaxWidth(),
                state = state,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(imageList) { index, imageData ->
                    SingleImage(
                        imageData = imageData,
                        onClickLikes =
                            {
                                imageList[index] = imageData.copy(likes = imageData.likes + 1)
                            },
                        onClickDislikes =
                            {
                                imageList[index] = imageData.copy(dislikes = imageData.dislikes + 1)
                            },
                    )
                }
            }
            AnimatedVisibility(showButton) {
                ScrollToTopButton {
                    scope.launch {
                        state.scrollToItem(0)
                    }
                }
            }
        }
    }

//--------------------------------------------------------------------------
//    val imageList = imageViewModel.imageList
//    val scrollState = rememberScrollState()
//    val orientation = LocalConfiguration.current.orientation
//    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
//        Column(
//            Modifier.fillMaxWidth().verticalScroll(scrollState),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            ImageList(imageList = imageList)
//        }
//    } else {
//        Row(
//            Modifier.fillMaxHeight().horizontalScroll(scrollState),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            ImageList(imageList = imageList)
//        }
//    }
//--------------------------------------------------------------------------
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
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}