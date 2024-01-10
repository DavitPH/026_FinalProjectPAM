package com.example.a026_finalprojectpam.Navigasi

import AuthenticationScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a026_finalprojectpam.Authentication.AuthViewModel
import com.example.a026_finalprojectpam.InformasiMotor.MotorViewModel
import com.example.a026_finalprojectpam.InformasiMotor.Screen.GetDataMotorScreen
import com.example.a026_finalprojectpam.InformasiMotor.Screen.AddDataMotorScreen
import com.example.a026_finalprojectpam.InformasiMotor.Screen.GetDataSewaScreen
import com.example.a026_finalprojectpam.InformasiMotor.Screen.MotorScreen
import com.example.a026_finalprojectpam.PenyewaanMotor.Screen.AddDataSewaScreen
import com.example.a026_finalprojectpam.PenyewaanMotor.Screen.SewaScreen
import com.example.a026_finalprojectpam.PenyewaanMotor.SewaViewModel

@Composable
fun NavigasiHalaman(
    navController: NavHostController,
    motorViewModel: MotorViewModel,
    authViewModel: AuthViewModel,
    sewaViewModel: SewaViewModel,
){
    NavHost(
        navController = navController,
        startDestination = Screens.AuthenticationScreen.route
    ) {
        composable(
            route = Screens.AuthenticationScreen.route
        ) {
            AuthenticationScreen(navController = navController, authViewModel = authViewModel)
        }
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


        composable(
            route = Screens.SewaScreen.route
        ) {
            SewaScreen(navController = navController, sewaViewModel = sewaViewModel)
        }
        // get data screen
        composable(
            route = Screens.GetDataSewaScreen.route
        ) {
            GetDataSewaScreen(navController = navController, sewaViewModel = sewaViewModel)

        }
        // add data screen
        composable(
            route = Screens.AddDataSewaScreen.route
        ){
            AddDataSewaScreen(navController = navController, sewaViewModel = sewaViewModel)
        }
    }
}