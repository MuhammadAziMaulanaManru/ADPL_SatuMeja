package com.example.satumeja.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.ComponentActivity
import com.example.satumeja.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomePageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)
        val fingerprintButton = findViewById<ImageButton>(R.id.fingerprint_button)
        fingerprintButton.setOnClickListener {
            navigateToHeadmasterActivity()
        }
        val home_button = findViewById<ImageButton>(R.id.imageView4)
        home_button.setOnClickListener {
            navigateToHomeActivity()
        }

        val storageDir = filesDir
        val files = storageDir.listFiles()

        if (files != null) {
            var imageViewIndex = 1 // Track the ImageView index
            for (file in files) {
                if (file.isFile) {
                    if (file.exists()) {
                        var imageView : ImageView? = null
                      if (imageViewIndex == 1) {
                         imageView = findViewById<ImageView>(R.id.image_1)
                         imageView.visibility = View.VISIBLE
                      }
                        if (imageViewIndex == 2) {
                         imageView = findViewById<ImageView>(R.id.image_2)
                         imageView.visibility = View.VISIBLE
                      }
                        if (imageViewIndex == 3) {
                         imageView = findViewById<ImageView>(R.id.image_3)
                         imageView.visibility = View.VISIBLE
                      }
                        val bitmap: Bitmap? = BitmapFactory.decodeFile(file.toString())
                        Log.d("MyActivity", "File : ${file.name}")
                        if (file.name.contains("captured_image_") && bitmap != null && imageView != null) {
                            imageView.setImageBitmap(bitmap)
                            imageViewIndex++
                        } else {
                            // Handle the case where decodeFile returns null (e.g., log error or display placeholder)
                            Log.w("MyActivity", "Failed to decode image: " + file.name)
                        }
                    }
                }
            }
        }
    }
    private fun navigateToChefActivity() {
        Log.d("MyActivity", "Chef") // Example logging
        val intent: Intent = Intent(this@HomePageActivity, CreateRecipeActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToMenuActivity() {
        Log.d("MyActivity", "Student") // Example logging
        val intent: Intent = Intent(this@HomePageActivity, ConfirmMenuActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToHeadmasterActivity() {
        Log.d("MyActivity", "Headmaster") // Example logging
        val intent: Intent = Intent(this@HomePageActivity, HeadmasterActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToHomeActivity() {
        Log.d("MyActivity", "Click Home") // Example logging
        CoroutineScope(Dispatchers.IO).launch {  // Launch on a background thread
            while (true) {
                delay(2000L)
                val intent: Intent =
                    Intent(
                        this@HomePageActivity,
                        HomePageActivity::class.java
                    )
                startActivity(intent)
                finish()
                break;
            }
        }
    }
}
