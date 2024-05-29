package com.example.satumeja.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.satumeja.R

class FingerprintSetupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_fingerprint_kepalasekolah)
        val confirmButton = findViewById<Button>(R.id.confirmButton)
        confirmButton.setOnClickListener {
            onConfirmButtonClicked()
        }
    }
    private fun onConfirmButtonClicked() {

        // Do something with the retrieved OTP (e.g., validation, verification with server)
        Log.d("MyActivity", "Fingerprint") // Example logging
        val intent = Intent(this@FingerprintSetupActivity, LoadingFingerprintActivity::class.java)
        startActivity(intent)
        finish()
    }
}
