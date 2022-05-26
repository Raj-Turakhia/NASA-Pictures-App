package com.nasa.pictureapp.ui.detail

import androidx.lifecycle.MutableLiveData
import com.nasa.pictureapp.di.base.BaseViewModel
import com.nasa.pictureapp.repository.models.NasaPictureModel
import com.nasa.pictureapp.util.extension.asLiveData
import javax.inject.Inject

class DetailViewModel @Inject constructor() :
    BaseViewModel() {

    private val _pictureModel = MutableLiveData<NasaPictureModel?>()
    val pictureModel = _pictureModel.asLiveData()

    fun setPictureData(pictureModel: NasaPictureModel?) {
        _pictureModel.postValue(pictureModel)
    }
}