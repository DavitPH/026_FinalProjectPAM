package com.example.a026_finalprojectpam.Navigasi


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a026_finalprojectpam.Authentication.AuthScreen
import com.example.a026_finalprojectpam.Authentication.AuthViewModel
import com.example.a026_finalprojectpam.HomePage.HomeScreen
import com.example.a026_finalprojectpam.HomePage.HomeViewModel
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
    sewaViewModel: SewaViewModel,
    homeViewModel: HomeViewModel,
    authViewModel: AuthViewModel,

){
    NavHost(
        navController = navController,
        startDestination = Screens.AuthScreen.route
    ) {

        composable(route = Screens.AuthScreen.route) {
            AuthScreen(
                navController = navController,
                authViewModel = authViewModel,
                onLoginSuccess = {
                    // Handle success, e.g., navigate to the home screen
                    navController.navigate(Screens.HomeScreen.route)
                }
            )
        }
        composable(
            route = Screens.HomeScreen.route
        ) {
            HomeScreen(navController = navController, homeViewModel = homeViewModel)
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