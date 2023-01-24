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
import ru.sotnikov.selecter.ui.SelecterScreen
import ru.sotnikov.selecterdetail.ui.SelecterDetailScreen
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
        composable(
            NavigationItem.SelectedPhotos.route.plus("/{camera}").plus("/{date}"),
            arguments = listOf(navArgument("date") { type = NavType.StringType },
                navArgument("camera") { type = NavType.StringType })
        ) {
            SelecterScreen(
                navController = navController,
                it.arguments?.getString("date").plus(""),
                it.arguments?.getString("camera").plus("")
            )
        }
        composable(
            NavigationItem.CheckPhoto.route.plus("/{id}").plus("/{imgSrc}"),
            arguments = listOf(navArgument("id") { type = NavType.StringType },
                navArgument("imgSrc") { type = NavType.StringType })
        ) {
            SelecterDetailScreen(navController,
                it.arguments?.getString("id").plus(""),
                it.arguments?.getString("imgSrc").plus(""))
        }
    }
}
