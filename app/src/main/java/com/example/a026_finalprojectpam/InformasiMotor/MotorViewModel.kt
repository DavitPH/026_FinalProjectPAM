package com.example.a026_finalprojectpam.InformasiMotor

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MotorViewModel(): ViewModel(){

    fun saveData(
        dataMotor: DataMotor,
        context: Context
    )    = CoroutineScope(Dispatchers.IO).launch {
        val fireStoreRef = Firebase.firestore
            .collection("motor")
            .document(dataMotor.idMotor)

        try{
            fireStoreRef.set(dataMotor)
                .addOnSuccessListener {
                    Toast.makeText(context, "Succsesfully saved data", Toast.LENGTH_LONG).show()
                }
        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

}