package ru.sotnikov.settings.ui


import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import ru.sotnikov.marsbycuriosity_api.usecase.GetCameraNameUseCase


internal class SettingViewModel(
    private val getCameraNameUseCase: GetCameraNameUseCase
) : ViewModel(), ContainerHost<SettingState, SettingSideEffect> {
    override val container = container<SettingState, SettingSideEffect>(SettingState())
    fun updateCamerasList(apiKey: String, date: String) = intent {
        val cameras = getCameraNameUseCase(apiKey, date)
        reduce {
            state.copy(cameraList = cameras.map { it.camera })
        }

    }

    fun updateDate(date: String) = intent {
        reduce {
            state.copy(date = date)
        }
    }

    fun updateCamera(camera: String) = intent {
        reduce {
            state.copy(camera = camera)
        }
    }


}
