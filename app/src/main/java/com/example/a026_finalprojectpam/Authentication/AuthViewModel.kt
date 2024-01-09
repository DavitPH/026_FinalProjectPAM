package com.example.a026_finalprojectpam.Authentication

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Properti state untuk menampilkan pemberitahuan
    private val _showSuccessMessage = MutableStateFlow<String?>(null)
    val showSuccessMessage = _showSuccessMessage.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage.asStateFlow()


    fun createUserWithEmailAndPassword(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Registrasi sukses, set pemberitahuan
                    _showSuccessMessage.value = "Registrasi berhasil!"
                } else {
                    // Registrasi gagal, tampilkan pesan kesalahan jika perlu
                }
            }
    }

    fun signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Login sukses, set pemberitahuan
                    _showSuccessMessage.value = "Login berhasil!"
                } else {
                    // Login gagal, set pesan kesalahan
                    _errorMessage.value = task.exception?.message ?: "Login gagal."
                }
            }
    }
    fun getCurrentUser(): FirebaseUser? = auth.currentUser

}