package com.example.satumeja.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.satumeja.R

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            onLoginButtonClicked()
        }
    }
    private fun onLoginButtonClicked() {
        val schoolName = findViewById<EditText>(R.id.schoolNameEditText).text.toString()  // Get school name

        // Do something with the retrieved school name (e.g., validation, network calls)
        Log.d("MyActivity", "School Name: $schoolName") // Example logging
        val intent = Intent(this@SignInActivity, VerifyOtpActivity::class.java)
        startActivity(intent)
        finish()
    }
}
