package ru.sotnikov.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Immutable
data class AppColor(
    val primary: Color,
    val primaryVariant: Color,
    val secondary: Color,
    val background: Color
)

@Immutable
data class AppTypography(
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle
)

val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Secondary,
    background = Background
)

val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Secondary,
    background = Background
)

val LocalColors = staticCompositionLocalOf {
    AppColor(
        primary = Color.Unspecified,
        primaryVariant =Color.Unspecified,
        secondary = Color.Unspecified,
        background = Color.Unspecified,
    )
}



@Composable
fun MarsByCuriosityTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
@Suppress
object MarsByCuriosityTheme {
    @Suppress
    val colors: AppColor
        @Composable
        get() = LocalColors.current
}
