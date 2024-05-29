package com.example.satumeja.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.satumeja.R

class LoadingFingerprintActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading_register)
        val verifyButton = findViewById<Button>(R.id.confirmButton)
        verifyButton.setOnClickListener {
            onConfirmButtonClicked()
        }
    }
    private fun onConfirmButtonClicked() {

        // Do something with the retrieved OTP (e.g., validation, verification with server)
        Log.d("MyActivity", "Loading Fingerprint") // Example logging
        val intent = Intent(this@LoadingFingerprintActivity, HomePageActivity::class.java)
        startActivity(intent)
        finish()
    }
}
