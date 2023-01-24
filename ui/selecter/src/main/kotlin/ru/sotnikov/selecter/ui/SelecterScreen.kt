package ru.sotnikov.selecter.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import org.koin.androidx.compose.viewModel
import ru.sotnikov.core.ui.R
import ru.sotnikov.core.ui.theme.MarsByCuriosityTheme
import ru.sotnikov.core.ui.theme.familyDosis
import ru.sotnikov.navigation.NavigationItem
import java.net.URLEncoder
import java.util.Base64

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SimpleDateFormat")
@Composable
fun SelecterScreen(
    navController: NavController,
    date: String,
    camera: String
) {
    val viewModel: SelecterViewModel by viewModel()
    viewModel.updateCamerasList(
        apiKey = stringResource(id = R.string.NasaOpenApis),
        date = date,
        camera = camera
    )
    val state = viewModel.container.stateFlow.collectAsState().value

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
                if (state.cameraList.isNotEmpty()) Column(
                    modifier = Modifier
                        .padding(horizontal = 56.dp)
                        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = state.cameraList[0].camera.fullName,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontFamily = familyDosis,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        text = date,//SimpleDateFormat("dd MMM, yyyy").format(SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(date) as Date),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontFamily = familyDosis,
                        fontSize = 13.sp
                    )
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(12.dp),
                modifier = Modifier.navigationBarsPadding()
            ) {
                items(state.cameraList) {
                    Image(
                        painter = rememberImagePainter(it.imgSrc),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(4.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .aspectRatio(1.0F)
                            .clickable {
                                navController.navigate(
                                    NavigationItem.CheckPhoto.route
                                        .plus("/${it.id}")
                                        .plus("/${URLEncoder.encode(it.imgSrc)}")
                                )
                            }
                    )
                }
            }
        }
    }
}
