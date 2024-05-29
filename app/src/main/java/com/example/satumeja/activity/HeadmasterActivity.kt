package com.example.satumeja.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import com.example.satumeja.R

class HeadmasterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.headmaster)
        val statisticButton = findViewById<Button>(R.id.button1)
        statisticButton.setOnClickListener {
            navigateToStatisticActivity()
        }
//        val scanFingerprintButton = findViewById<Button>(R.id.button1)
//        scanFingerprintButton.setOnClickListener {
//            navigateToRegisterFingerprintActivity()
//        }
        val home_button = findViewById<ImageButton>(R.id.imageView6)
        home_button.setOnClickListener {
            navigateToHomeActivity()
        }
    }
    private fun navigateToStatisticActivity() {
        Log.d("MyActivity", "Statistic") // Example logging
        val intent: Intent = Intent(this@HeadmasterActivity, ShowRoomDataActivity::class.java)
        startActivity(intent)
    }
//    private fun navigateToRegisterFingerprintActivity() {
//        Log.d("MyActivity", "Student") // Example logging
//        val intent: Intent = Intent(this@HeadmasterActivity, RegisterUserActivity::class.java)
//        startActivity(intent)
//    }
    private fun navigateToHomeActivity() {
        Log.d("MyActivity", "Click Home") // Example logging
        val intent: Intent =
            Intent(
                this@HeadmasterActivity,
                HomePageActivity::class.java
            )
        startActivity(intent)
    }
}
