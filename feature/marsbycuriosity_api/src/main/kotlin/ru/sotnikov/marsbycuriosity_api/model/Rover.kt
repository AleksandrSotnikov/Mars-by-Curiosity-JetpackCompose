package ru.sotnikov.marsbycuriosity_api.model

data class Rover(
    val id: Int,
    val landingDate: String,
    val launchDate: String,
    val name: String,
    val status: String
)
