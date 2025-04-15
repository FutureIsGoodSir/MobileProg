package com.example.eweek05a.viewmodel

import androidx.lifecycle.ViewModel
import com.example.eweek05a.model.ImageData
import com.example.eweek05a.model.ImageListFactory

class ImageViewModel : ViewModel() {
    private val _imageList = ImageListFactory.makeImageList()
    val imageList: MutableList<ImageData>
        get() = _imageList
}