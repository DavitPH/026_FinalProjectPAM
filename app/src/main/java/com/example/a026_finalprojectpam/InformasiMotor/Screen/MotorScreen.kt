package com.example.a026_finalprojectpam.InformasiMotor.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a026_finalprojectpam.InformasiMotor.MotorViewModel
import com.example.a026_finalprojectpam.Navigasi.Screens

@Composable
fun MotorScreen(
    navController: NavController,
    motorViewModel: MotorViewModel,
){
    Column(
        modifier = Modifier
            .padding(start = 50.dp, end = 50.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // get user data Button
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.navigate(route = Screens.GetDataMotorScreen.route)
            }
        ) {
            Text(text = "Get Data Motor")
        }

        // add user data Button
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.navigate(route = Screens.AddDataMotorScreen.route)
            }
        ) {
            Text(text = "Add User Data")
        }
    }
}