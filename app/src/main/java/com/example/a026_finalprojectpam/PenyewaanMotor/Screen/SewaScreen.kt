package com.example.a026_finalprojectpam.PenyewaanMotor.Screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.a026_finalprojectpam.PenyewaanMotor.DataSewa
import com.example.a026_finalprojectpam.PenyewaanMotor.SewaViewModel


@Composable
fun SewaScreen(
    navController: NavController,
    sewaViewModel: SewaViewModel = viewModel()
) {
    val allDataState by sewaViewModel.getAllData().collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        item {
            Text(
                text = "Data Penyewaan",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        items(allDataState) { sewaData ->
            SewaListItem(sewaData = sewaData)
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                IconButton(
                    onClick = { navController.navigateUp() }
                ) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }

                OutlinedButton(
                    onClick = { },
                ) {
                    Text(text = "Add Data Penyewaan")
                }

                OutlinedButton(
                    onClick = {},
                ) {
                    Text(text = "Get Data Penyewaan")
                }
            }
        }
    }
}


@Composable
fun SewaListItem(sewaData: DataSewa) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray)
            .padding(8.dp)
    ) {
        Column {
            Text(text = "ID Sewa: ${sewaData.idSewa}", fontSize = 16.sp)
            Text(text = "ID Motor: ${sewaData.idMotor}")
            Text(text = "Nama Penyewa: ${sewaData.nmPenyewa}")
            Text(text = "Nomer Telepon: ${sewaData.noHp}")
            Text(text = "Tanggal Menyewa: ${sewaData.tglSewa}")
            Text(text = "Tanggal Kembali: ${sewaData.tglKembali}")
        }
    }
}