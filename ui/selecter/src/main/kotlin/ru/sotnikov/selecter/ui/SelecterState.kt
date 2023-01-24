package ru.sotnikov.selecter.ui

import ru.sotnikov.marsbycuriosity_api.model.Photo

data class SelecterState(
    val date: String = "",
    val camera: String = "",
    val cameraList: List<Photo> = emptyList()
)
