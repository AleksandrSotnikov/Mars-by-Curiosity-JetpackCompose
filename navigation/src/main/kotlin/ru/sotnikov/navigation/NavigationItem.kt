package ru.sotnikov.navigation

sealed class NavigationItem (val route: String){
    object SelectedCameraAndDate: NavigationItem(
        route = "cameraAndDate"
    )
    object SelectedPhotos: NavigationItem(
        route = "Photos"
    )
    object CheckPhoto: NavigationItem(
        route = "CheckPhoto"
    )
}
