package ru.sotnikov.selecter.ui

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import ru.sotnikov.marsbycuriosity_api.usecase.GetPhotosUseCase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

internal class SelecterViewModel(
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel(), ContainerHost<SelecterState, SelecterSideEffect> {
    override val container = container<SelecterState, SelecterSideEffect>(SelecterState())
    fun updateCamerasList(apiKey: String, date: String, camera: String) = intent {
        val photos = getPhotosUseCase(apiKey, ConvertDate(date), ConvertCamera(camera))
        reduce {
            state.copy(cameraList = photos)
        }
    }

    fun ConvertCamera(cameraName: String): String {
        when (cameraName) {
            "Front Hazard Avoidance Camera" -> return "FHAZ"
            "Rear Hazard Avoidance Cameraa" -> return "RHAZ"
            "Mast Camera" -> return "MAST"
            "Chemistry and Camera Complex" -> return "CHEMCAM"
            "Mars Hand Lens Imager" -> return "MAHLI"
            "Mars Descent Imager" -> return "MARDI"
            "Navigation Camera" -> return "NAVCAM"
        }
        return ""
    }

    @SuppressLint("SimpleDateFormat")
    fun ConvertDate(date: String): String {
        return SimpleDateFormat("yyyy-MM-dd").format(SimpleDateFormat("dd MMM, yyyy", Locale.US).parse(date) as Date)
    }
}
