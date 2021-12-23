package ru.sotnikov.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import ru.sotnikov.core.ui.theme.MarsByCuriosityTheme

@ExperimentalAnimationApi
@Composable
fun MainContainer() {
    val navController = rememberAnimatedNavController()
    ProvideWindowInsets {
        MarsByCuriosityTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {

            }
        }
    }
}



@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun MainContainerPreview() {
    MarsByCuriosityTheme {
        MainContainer()
    }
}
