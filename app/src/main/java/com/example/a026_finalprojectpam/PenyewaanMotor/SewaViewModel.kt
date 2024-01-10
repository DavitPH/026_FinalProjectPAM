package com.example.a026_finalprojectpam.PenyewaanMotor

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

class SewaViewModel() : ViewModel() {

    fun getAllData(): kotlinx.coroutines.flow.Flow<List<DataSewa>> = callbackFlow {
        val fireStoreRef = Firebase.firestore.collection("sewa")

        val subscription = fireStoreRef.addSnapshotListener { value, error ->
            if (error != null) {
                // Handle error
                close(error)
                return@addSnapshotListener
            }

            if (value != null) {
                val dataList = mutableListOf<DataSewa>()
                for (doc in value.documents) {
                    val dataSewa = doc.toObject(DataSewa::class.java)
                    if (dataSewa != null) {
                        dataList.add(dataSewa)
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

    fun saveData(
        dataSewa: DataSewa,
        context: Context
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("sewa")
            .document(dataSewa.idSewa)

        try {
            fireStoreRef.set(dataSewa)
                .addOnSuccessListener {
                    Toast.makeText(context, "Successfully saved data", Toast.LENGTH_SHORT).show()
                }
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun retrieveData(
        idSewa: String,
        context: Context,
        data: (DataSewa) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("sewa")
            .document(idSewa)

        try {
            fireStoreRef.get()
                .addOnSuccessListener {
                    // for getting single or particular document
                    if (it.exists()) {
                        val dataSewa = it.toObject<DataSewa>()!!
                        data(dataSewa)
                    } else {
                        Toast.makeText(context, "No User Data Found", Toast.LENGTH_SHORT).show()
                    }
                }
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteData(
        idSewa: String,
        context: Context,
        navController: NavController,
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("sewa")
            .document(idSewa)

        try {
            fireStoreRef.delete()
                .addOnSuccessListener {
                    Toast.makeText(context, "Successfully deleted data", Toast.LENGTH_SHORT)
                        .show()
                    navController.popBackStack()
                }
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }
}