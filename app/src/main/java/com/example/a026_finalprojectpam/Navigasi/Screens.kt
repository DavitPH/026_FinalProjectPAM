package com.example.a026_finalprojectpam.Navigasi

sealed class Screens(val route: String) {
    object MotorScreen: Screens(route = "motor_screen")
    object GetDataMotorScreen: Screens(route = "get_data_Motor_screen")
    object AddDataMotorScreen: Screens(route = "add_data_motor_screen")
    object AuthScreen : Screens(route = "auth_screen") // Tambahkan opsi untuk AuthScreen
    object HomeScreen : Screens(route = "home_screen")
    object SewaScreen: Screens(route = "sewa_screen")
    object GetDataSewaScreen: Screens(route = "get_data_Sewa_screen")
    object AddDataSewaScreen: Screens(route = "add_data_Sewa_screen")

}