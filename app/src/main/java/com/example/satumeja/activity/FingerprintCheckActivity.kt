package com.example.satumeja.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import com.example.satumeja.R


class FingerprintCheckActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_fingerprint)
        val verifyButton = findViewById<Button>(R.id.start_button)
        verifyButton.setOnClickListener { // Navigate to VerifyFingerprintActivity
            navigateToVerifyFingerprintActivity()
        }
        val send_button = findViewById<ImageButton>(R.id.imageView6)
        send_button.setOnClickListener {
            navigateToHomeActivity()
        }
    }
    private fun navigateToHomeActivity() {
        Log.d("MyActivity", "Click Home") // Example logging
        val intent: Intent =
            Intent(
                this@FingerprintCheckActivity,
                HomePageActivity::class.java
            )
        startActivity(intent)
    }
    private fun navigateToVerifyFingerprintActivity() {
        Log.d("MyActivity", "Check Fingerprint") // Example logging
        val intent: Intent = Intent(this@FingerprintCheckActivity, ConfirmMenuActivity::class.java)
        startActivity(intent)
    }
}
