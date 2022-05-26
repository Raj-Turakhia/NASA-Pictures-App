package com.nasa.pictureapp.utils

import com.nasa.pictureapp.repository.models.NasaPictureModel

object MockUtils {

    val nasaPictureModel = NasaPictureModel(url = "https://apod.nasa.gov/apod/image/1912/M94_Hubble_960.jpg",
    title = "Starburst Galaxy M94 from Hubble")
    val nasaPictureModelList = listOf(nasaPictureModel)
}