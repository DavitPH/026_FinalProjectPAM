package com.example.a026_finalprojectpam.InformasiMotor

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

class MotorViewModel(): ViewModel(){

    fun getAllData(): kotlinx.coroutines.flow.Flow<List<DataMotor>> = callbackFlow {
        val fireStoreRef = Firebase.firestore.collection("motor")

        val subscription = fireStoreRef.addSnapshotListener { value, error ->
            if (error != null) {
                // Handle error
                close(error)
                return@addSnapshotListener
            }

            if (value != null) {
                val dataList = mutableListOf<DataMotor>()
                for (doc in value.documents) {
                    val dataMotor = doc.toObject(DataMotor::class.java)
                    if (dataMotor != null) {
                        dataList.add(dataMotor)
                    }
                }
                trySend(dataList)
            }
        }

        // Cancellation callback
        awaitClose {
            subscription.remove()
        }
    }
        // Cancellation callback


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

    fun retrieveData(
        idMotor: String,
        context: Context,
        data: (DataMotor) -> Unit
    )    = CoroutineScope(Dispatchers.IO).launch {
        val fireStoreRef = Firebase.firestore
            .collection("motor")
            .document(idMotor)

        try{
            fireStoreRef.get()
                .addOnSuccessListener {
                   if (it.exists()){
                       val dataMotor = it.toObject<DataMotor>()!!
                       data(dataMotor)
                   } else {
                       Toast.makeText(context, "No User Data Found", Toast.LENGTH_SHORT).show()
                   }
                }
        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun delateData(
        idMotor: String,
        context: Context,
        navController: NavController,
    )    = CoroutineScope(Dispatchers.IO).launch {
        val fireStoreRef = Firebase.firestore
            .collection("motor")
            .document(idMotor)

        try{
            fireStoreRef.delete()
                .addOnSuccessListener {
                    Toast.makeText(context, "Succsesfully delate data", Toast.LENGTH_LONG).show()
                    navController.popBackStack()
                }
        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

}