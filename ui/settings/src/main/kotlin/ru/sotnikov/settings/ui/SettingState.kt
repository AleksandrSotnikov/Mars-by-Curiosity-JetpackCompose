package ru.sotnikov.settings.ui

import ru.sotnikov.marsbycuriosity_api.model.Camera

data class SettingState(
    val date:String = "",
    val camera:String= "",
    val cameraList:List<Camera> = emptyList()
)
