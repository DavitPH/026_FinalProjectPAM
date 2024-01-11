package com.example.a026_finalprojectpam.InformasiMotor.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a026_finalprojectpam.InformasiMotor.DataMotor
import com.example.a026_finalprojectpam.InformasiMotor.MotorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDataMotorScreen (
    navController: NavController,
    motorViewModel: MotorViewModel,
){
    var idMotor: String by remember { mutableStateOf("") }
    var nmMotor: String by remember { mutableStateOf("") }
    var pltMotor: String by remember { mutableStateOf("") }
    var wrnMotor: String by remember { mutableStateOf("") }
    var hrgMotor: String by remember { mutableStateOf("") }

    val context = LocalContext.current

    // main Layout
    Column(modifier = Modifier.fillMaxSize()) {
        // back button
        Row(
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back_button")
            }
        }
        // add data Layout
        Column(
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp, bottom = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // ID
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = idMotor,
                onValueChange = {
                    idMotor = it
                },
                label = {
                    Text(text = "ID Motor")
                }
            )
            // Name
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nmMotor,
                onValueChange = {
                    nmMotor = it
                },
                label = {
                    Text(text = "Nama Motor")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = pltMotor,
                onValueChange = {
                    pltMotor = it
                },
                label = {
                    Text(text = "Nomer Plat Motor")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = wrnMotor,
                onValueChange = {
                    wrnMotor = it
                },
                label = {
                    Text(text = "Warna Motor")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = hrgMotor,
                onValueChange = {
                    hrgMotor = it
                },
                label = {
                    Text(text = "Harga Sewa/Hari")
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )

            )

            // save Button
            Button(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth(),
                onClick = {
                    val dataMotor = DataMotor(
                        idMotor = idMotor,
                        nmMotor = nmMotor,
                        pltMotor = pltMotor,
                        wrnMotor = wrnMotor,
                        hrgMotor = hrgMotor
                    )

                    motorViewModel.saveData(dataMotor = dataMotor, context = context)
                }
            ) {
                Text(text = "Save")
            }
        }
    }
}
