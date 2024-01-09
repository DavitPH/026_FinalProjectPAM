package com.example.a026_finalprojectpam.InformasiMotor.Screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a026_finalprojectpam.InformasiMotor.MotorViewModel
import com.example.a026_finalprojectpam.Navigasi.Screens

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a026_finalprojectpam.InformasiMotor.DataMotor

@Composable
fun MotorScreen(
    navController: NavController,
    motorViewModel: MotorViewModel = viewModel()
) {
    val allDataState by motorViewModel.getAllData().collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        item {
            Text(
                text = "Motor Data",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        items(allDataState) { motorData ->
            MotorListItem(motorData = motorData)
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                IconButton(
                    onClick = { navController.navigateUp() }
                ) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }

                OutlinedButton(
                    onClick = {  navController.navigate(route = Screens.AddDataMotorScreen.route) },
                ) {
                    Text(text = "Add Data Motor")
                }

                OutlinedButton(
                    onClick = { navController.navigate(route = Screens.GetDataMotorScreen.route) },
                ) {
                    Text(text = "Get Data Motor")
                }
            }
        }
    }
}


@Composable
fun MotorListItem(motorData: DataMotor) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray)
            .padding(8.dp)
    ) {
        Column {
            Text(text = "ID: ${motorData.idMotor}", fontSize = 16.sp)
            Text(text = "Name: ${motorData.nmMotor}")
            Text(text = "Plate: ${motorData.pltMotor}")
            Text(text = "Color: ${motorData.wrnMotor}")
            Text(text = "Price: ${motorData.hrgMotor}")
        }
    }
}