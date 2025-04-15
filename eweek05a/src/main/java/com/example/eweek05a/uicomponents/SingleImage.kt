package com.example.eweek05a.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.eweek05a.model.ButtonType
import com.example.eweek05a.model.ImageData

@Composable
fun SingleImage(
    modifier: Modifier = Modifier,
    imageData: ImageData,
    onClickLikes: () -> Unit,
    onClickDislikes: () -> Unit
) {
    when (imageData.buttonType) {
        ButtonType.ICON -> {
            ImageWithButton(image = imageData.image) {
                ButtonWithIcon(likes = imageData.likes) {
                    onClickLikes()
                }
            }
        }

        ButtonType.BADGE -> {
            ImageWithButton(image = imageData.image) {
                ButtonWithBadge(likes = imageData.likes) {
                    onClickLikes()
                }
            }
        }

        ButtonType.EMOJI -> {
            ImageWithButton(image = imageData.image) {
                ButtonWithEmoji(
                    likes = imageData.likes,
                    dislikes = imageData.dislikes,
                    onClickLikes = {
                        onClickLikes()
                    },
                    onClickDisLikes = {
                        onClickDislikes()
                    }
                )
            }
        }
    }
}