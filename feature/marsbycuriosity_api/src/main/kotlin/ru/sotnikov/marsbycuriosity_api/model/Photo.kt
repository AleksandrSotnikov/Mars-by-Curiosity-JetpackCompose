package ru.sotnikov.marsbycuriosity_api.model

data class Photo(
    val camera: Camera,
    val earthDate: String,
    val id: Int,
    val imgSrc: String,
    val rover: Rover,
    val sol: Int
)
