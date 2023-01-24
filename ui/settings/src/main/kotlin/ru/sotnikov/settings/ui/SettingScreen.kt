package ru.sotnikov.settings.ui

import android.annotation.SuppressLint
import android.util.Log
import android.widget.CalendarView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import org.koin.androidx.compose.viewModel
import ru.sotnikov.core.ui.theme.MarsByCuriosityTheme
import ru.sotnikov.core.ui.theme.familyDosis
import ru.sotnikov.navigation.NavigationItem
import ru.sotnikov.settings.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SimpleDateFormat", "StateFlowValueCalledInComposition")
@Composable
fun SettingScreen(
    navController: NavController,
) {
    val viewModel: SettingViewModel by viewModel()
    var expandedDropDownMenu by remember { mutableStateOf(false) }
    var expandedCalendar by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("No cameras found") }
    var date by remember {
        mutableStateOf(
            SimpleDateFormat(
                "dd MMM, yyyy",
                Locale.US
            ).format(Calendar.getInstance().time)
        )
    }
    viewModel.updateCamerasList(
        apiKey = stringResource(id = ru.sotnikov.core.ui.R.string.NasaOpenApis),
        date = SimpleDateFormat("yyyy-MM-dd").format(SimpleDateFormat("dd MMM, yyyy", Locale.US).parse(date) as Date)
    )
    val state = viewModel.container.stateFlow.collectAsState().value
    Scaffold(modifier = Modifier.background(color = MarsByCuriosityTheme.colors.background)) {
        Text(
            text = "Select Camera and Date", textAlign = TextAlign.Center, modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(start = 56.dp, top = 42.dp, end = 56.dp),
            fontFamily = familyDosis,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = painterResource(id = R.drawable.curiosity),
            alignment = Alignment.BottomCenter,
            contentDescription = "Curiosity",
            modifier = Modifier
                .navigationBarsPadding()
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Rover Camera",
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                fontFamily = familyDosis,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.padding(bottom = 8.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent)) {
                DropdownMenu(
                    expanded = expandedDropDownMenu,
                    onDismissRequest = { expandedDropDownMenu = false },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .background(color = Color(0xFFDCCEBE))
                ) {
                    state.cameraList.distinctBy { it.fullName }.forEach {
                        DropdownMenuItem(
                            onClick = {
                                selected = it.fullName
                                viewModel.updateCamera(selected)
                                expandedDropDownMenu = false
                                if (state.cameraList.isEmpty()) selected = "No cameras found"
                            }, modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.Transparent)
                        ) {
                            Text(
                                text = it.fullName,
                                fontFamily = familyDosis,
                                maxLines = 1,
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(color = Color(0x80FFFFFF), shape = RoundedCornerShape(10.dp))
                ) {
                    Text(
                        text = selected,
                        modifier = Modifier.padding(start = 16.dp),
                        fontFamily = familyDosis,
                        fontSize = 18.sp
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.dropdown),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable { expandedDropDownMenu = true }
                            .rotate(if (expandedDropDownMenu) 180f else 0f)
                    )
                }
            }
            Spacer(modifier = Modifier.padding(bottom = 16.dp))
            Text(
                text = "Date",
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                fontFamily = familyDosis,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.padding(bottom = 8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(color = Color(0x80FFFFFF), shape = RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = date,
                    modifier = Modifier.padding(start = 16.dp),
                    fontFamily = familyDosis,
                    fontSize = 18.sp
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.calendar),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .clickable { expandedCalendar = true }
                )
            }
            Spacer(modifier = Modifier.padding(bottom = 40.dp))
            Button(
                onClick = {
                    if (selected != "No cameras found") {
                        Log.e("qqq", date + " " + selected + " " + state.camera + " " + state.camera)
                        navController.navigate(
                            NavigationItem.SelectedPhotos.route.plus("/$selected").plus("/$date")
                        )
                    }
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFBF2E0E)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(
                    text = "Explore",
                    color = Color.White,
                    fontFamily = familyDosis,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        if (expandedCalendar)
            Box(
                modifier = Modifier
                    .statusBarsPadding()
                    .navigationBarsPadding()
                    .padding(horizontal = 24.dp)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                AndroidView(
                    factory = { CalendarView(it) },
                    update = {
                        it.setOnDateChangeListener { calendarView, year, _, day ->
                            date = "$day ${SimpleDateFormat("MMM", Locale.US).format(calendarView.date)}, $year"
                            expandedCalendar = false
                            if (state.cameraList.isEmpty()) selected = "No cameras found"
                            viewModel.updateDate(date)
                        }
                    },
                    modifier = Modifier.background(color = Color(0xFFDCCEBE))
                )
            }
    }
}
