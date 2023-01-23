package ru.sotnikov.marsbycuriosity_impl.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rover(
    @SerialName("id")
    val id: Int,
    @SerialName("landing_date")
    val landingDate: String,
    @SerialName("launch_date")
    val launchDate: String,
    @SerialName("name")
    val name: String,
    @SerialName("status")
    val status: String
)

fun Rover.toDomain():ru.sotnikov.marsbycuriosity_api.model.Rover {
    return ru.sotnikov.marsbycuriosity_api.model.Rover(id = id, landingDate = landingDate,launchDate = launchDate,name = name, status = status)
}

