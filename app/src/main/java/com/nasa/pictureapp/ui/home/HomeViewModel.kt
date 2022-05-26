package com.nasa.pictureapp.ui.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nasa.pictureapp.di.base.BaseViewModel
import com.nasa.pictureapp.repository.models.NasaPictureModel
import com.nasa.pictureapp.util.Utils
import com.nasa.pictureapp.util.extension.asLiveData
import javax.inject.Inject

class HomeViewModel @Inject constructor(context : Context) :
    BaseViewModel() {

    private val _pictureModel = MutableLiveData<List<NasaPictureModel>?>()
    val pictureModel = _pictureModel.asLiveData()

    init {
        readPictureData(context)
    }

    /**
     * This method read json file from assets and parse data with Gson.
     */
    private fun readPictureData(context: Context) {
        val jsonFileString = Utils.getJsonDataFromAsset(context, "data.json")
        val listPictureType = object : TypeToken<List<NasaPictureModel>>() {}.type
        val nasaPictures: List<NasaPictureModel> = Gson().fromJson(jsonFileString, listPictureType)
        _pictureModel.postValue(nasaPictures)
    }
}