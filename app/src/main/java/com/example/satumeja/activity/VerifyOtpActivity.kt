package com.example.satumeja.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.satumeja.R

class VerifyOtpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otp)
        val verifyButton = findViewById<Button>(R.id.verifyButton)
        verifyButton.setOnClickListener {
            onVerifyButtonClicked()
        }
    }
    private fun onVerifyButtonClicked() {
        val otp1 = findViewById<EditText>(R.id.edit_text_1).text.toString()
        val otp2 = findViewById<EditText>(R.id.edit_text_2).text.toString()
        val otp3 = findViewById<EditText>(R.id.edit_text_3).text.toString()
        val otp4 = findViewById<EditText>(R.id.edit_text_4).text.toString()

        val fullOtp = "$otp1$otp2$otp3$otp4"  // Combine all digits

        // Do something with the retrieved OTP (e.g., validation, verification with server)
        Log.d("MyActivity", "OTP: $fullOtp") // Example logging
        val intent = Intent(this@VerifyOtpActivity, FingerprintSetupActivity::class.java)
        startActivity(intent)
        finish()
    }
}
