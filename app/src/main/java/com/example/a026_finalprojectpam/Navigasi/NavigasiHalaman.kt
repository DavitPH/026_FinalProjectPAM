package com.example.a026_finalprojectpam.Navigasi

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a026_finalprojectpam.InformasiMotor.MotorViewModel
import com.example.a026_finalprojectpam.InformasiMotor.Screen.GetDataMotorScreen
import com.example.a026_finalprojectpam.InformasiMotor.Screen.AddDataMotorScreen
import com.example.a026_finalprojectpam.InformasiMotor.Screen.MotorScreen

@Composable
fun NavigasiHalaman(
    navController: NavHostController,
    motorViewModel: MotorViewModel
){
    NavHost(
        navController = navController,
        startDestination = Screens.MotorScreen.route
    ) {
        // main screen
        composable(
            route = Screens.MotorScreen.route
        ) {
            MotorScreen(navController = navController, motorViewModel = motorViewModel)
        }
        // get data screen
        composable(
            route = Screens.GetDataMotorScreen.route
        ) {
            GetDataMotorScreen(navController = navController, motorViewModel = motorViewModel)

        }
        // add data screen
        composable(
            route = Screens.AddDataMotorScreen.route
        ){
            AddDataMotorScreen(navController = navController, motorViewModel = motorViewModel)
        }
    }
}