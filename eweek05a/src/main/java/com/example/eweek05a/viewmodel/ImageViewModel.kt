package com.example.eweek05a.viewmodel

import androidx.lifecycle.ViewModel
import com.example.eweek05a.model.ImageData
import com.example.eweek05a.model.ImageListFactory

class ImageViewModel : ViewModel() {//뷰 모델 클래스
    private val _imageList = ImageListFactory.makeImageList()
    val imageList: MutableList<ImageData>
        get() = _imageList//언더 바 이미지 리스트의 요소가 변경될 때 반영이 돼야 하기 때문에 겟을 써야 한다
//        get() {//이런 식으로 해도 됨
//            return _imageList
//        }
}