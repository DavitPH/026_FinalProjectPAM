package com.example.a026_finalprojectpam.InformasiMotor.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a026_finalprojectpam.PenyewaanMotor.DataSewa
import com.example.a026_finalprojectpam.PenyewaanMotor.SewaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetDataMotorScreen(
    navController: NavController,
    sewaViewModel: SewaViewModel,
){
    var idSewa: String by remember { mutableStateOf("") }
    var idMotor: String by remember { mutableStateOf("") }
    var nmPenyewa: String by remember { mutableStateOf("") }
    var noHp: String by remember { mutableStateOf("") }
    var tglSewa: String by remember { mutableStateOf("") }
    var tglKembali: String by remember { mutableStateOf("") }

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
        // get data Layout
        Column(
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp, bottom = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // userID
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    value = idMotor,
                    onValueChange = {
                        idMotor = it
                    },
                    label = {
                        Text(text = "ID Motor")
                    }
                )
                // get user data Button
                Button(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(100.dp),
                    onClick = {
                        sewaViewModel.retrieveData(
                            idSewa = idSewa,
                            context = context
                        ) { data ->
                            idMotor = data.idMotor
                            nmPenyewa = data.nmPenyewa
                            noHp = data.noHp
                            tglSewa = data.tglSewa
                            tglKembali = data.tglKembali
                        }
                    }
                ) {
                    Text(text = "Get Data")
                }
            }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = idMotor,
                onValueChange = {
                    idMotor = it
                },
                label = {
                    Text(text = "ID Motor Yang DiSewa")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nmPenyewa,
                onValueChange = {
                    nmPenyewa = it
                },
                label = {
                    Text(text = "Nama Penyewa")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = noHp,
                onValueChange = {
                    noHp = it
                },
                label = {
                    Text(text = "Nomer Telepon")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = tglSewa,
                onValueChange = {
                    tglSewa = it
                },
                label = {
                    Text(text = "Tanggal Penyewaan")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = tglKembali,
                onValueChange = {
                    tglKembali = it
                },
                label = {
                    Text(text = "Tanggal Kembali")
                }
            )

            Button(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth(),
                onClick = {
                    val dataSewa = DataSewa(
                        idSewa = idSewa,
                        idMotor = idMotor,
                        nmPenyewa = nmPenyewa,
                        noHp = noHp,
                        tglSewa = tglSewa,
                        tglKembali = tglKembali
                    )

                    sewaViewModel.saveData(dataSewa = dataSewa, context = context)
                }
            ) {
                Text(text = "Save")
            }
            // delete Button
            Button(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                onClick = {
                    sewaViewModel.deleteData(
                        idSewa = idSewa,
                        context = context,
                        navController = navController
                    )
                }
            ) {
                Text(text = "Delete")
            }
        }
    }
}
