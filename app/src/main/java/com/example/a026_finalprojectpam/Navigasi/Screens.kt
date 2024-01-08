package com.example.a026_finalprojectpam.Navigasi

sealed class Screens(val route: String) {
    object MotorScreen: Screens(route = "motor_screen")
    object GetDataMotorScreen: Screens(route = "get_data_Motor_screen")
    object AddDataMotorScreen: Screens(route = "add_data_motor_screen")
}