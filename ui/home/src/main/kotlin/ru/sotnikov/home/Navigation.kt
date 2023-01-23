package ru.sotnikov.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import ru.sotnikov.navigation.NavigationItem
import ru.sotnikov.settings.ui.SettingScreen


@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun Navigation(navController: NavHostController) {
    AnimatedNavHost(navController = navController,
        startDestination = NavigationItem.SelectedCameraAndDate.route,
        enterTransition = { fadeIn(animationSpec = tween(0)) },
        exitTransition = { fadeOut(animationSpec = tween(0)) },
        popEnterTransition = { fadeIn(animationSpec = tween(0)) },
        popExitTransition = { fadeOut(animationSpec = tween(0)) }) {
        composable(NavigationItem.SelectedCameraAndDate.route) {
            SettingScreen(navController = navController)
        }
        composable(NavigationItem.SelectedPhotos.route) {

        }
        composable(NavigationItem.CheckPhoto.route.plus("/{id}"),
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) {

        }
    }
}
