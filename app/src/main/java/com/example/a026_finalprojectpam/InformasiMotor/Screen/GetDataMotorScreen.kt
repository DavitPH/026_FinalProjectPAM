package com.example.a026_finalprojectpam.InformasiMotor.Screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.a026_finalprojectpam.InformasiMotor.MotorViewModel

@Composable
fun GetDataMotorScreen(
    navController: NavController,
    motorViewModel: MotorViewModel,
){
    var idMotor: String by remember { mutableStateOf("") }
    var nmMotor: String by remember { mutableStateOf("") }
    var pltMotor: String by remember { mutableStateOf("") }
    var wrnMotor: String by remember { mutableStateOf("") }
    var hrgMotor: String by remember { mutableStateOf("") }

    val context = LocalContext.current



}
