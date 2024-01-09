package com.example.a026_finalprojectpam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.a026_finalprojectpam.Authentication.AuthViewModel
import com.example.a026_finalprojectpam.InformasiMotor.MotorViewModel
import com.example.a026_finalprojectpam.Navigasi.NavigasiHalaman
import com.example.a026_finalprojectpam.ui.theme._026_FinalProjectPAMTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {

    val db = Firebase.firestore
    private lateinit var navController: NavHostController
    private val motorViewModel: MotorViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _026_FinalProjectPAMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navController = rememberNavController()
                    NavigasiHalaman(
                        navController = navController,
                        motorViewModel = motorViewModel,
                        authViewModel = authViewModel
                    )
                }
            }
        }
    }
}