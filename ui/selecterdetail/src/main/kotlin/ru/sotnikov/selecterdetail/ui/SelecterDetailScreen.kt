package ru.sotnikov.selecterdetail.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import ru.sotnikov.core.ui.R
import ru.sotnikov.core.ui.theme.MarsByCuriosityTheme
import ru.sotnikov.core.ui.theme.familyDosis
import ru.sotnikov.navigation.NavigationItem

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SelecterDetailScreen(
    navController: NavController,
    id: String,
    imgSrc: String
) {
    Scaffold(modifier = Modifier.background(color = MarsByCuriosityTheme.colors.background)) {
        Column() {
            Box(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(top = 42.dp)
                    .height(46.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.dropdown),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 25.dp)
                        .clickable { navController.navigate(NavigationItem.SelectedCameraAndDate.route) }
                        .rotate(90f)
                        .align(alignment = Alignment.CenterStart)
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.share),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 25.dp)
                        .clickable { navController.navigate(NavigationItem.SelectedCameraAndDate.route) }
                        .rotate(90f)
                        .align(alignment = Alignment.CenterEnd)
                )
                Column(
                    modifier = Modifier
                        .padding(horizontal = 56.dp)
                        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Photo ID",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontFamily = familyDosis,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        text = id,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontFamily = familyDosis,
                        fontSize = 13.sp
                    )
                }
            }
            Image(
                painter = rememberImagePainter(imgSrc.toString()),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .navigationBarsPadding()
                    .clip(RoundedCornerShape(8.dp))
                    .aspectRatio(1.0F)
            )
        }
    }
}
