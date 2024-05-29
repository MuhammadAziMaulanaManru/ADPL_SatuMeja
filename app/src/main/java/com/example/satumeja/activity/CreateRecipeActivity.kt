package com.example.satumeja.activity

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.satumeja.R
import java.io.File
import java.io.FileOutputStream


class CreateRecipeActivity : ComponentActivity() {
    private var clickedImageButtonId: Int = 0
    private var capturedImageUri: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chef)
        val imageButton = findViewById<ImageButton>(R.id.image_button)
        val imageButton1 = findViewById<ImageButton>(R.id.image_button1)
        val imageButton3 = findViewById<ImageButton>(R.id.image_button3)

        imageButton.setOnClickListener {
            clickedImageButtonId = R.id.image_button
            launchCameraIntent()
        }

        imageButton1.setOnClickListener {
            clickedImageButtonId = R.id.image_button1
            launchCameraIntent()
        }

        imageButton3.setOnClickListener {
            clickedImageButtonId = R.id.image_button3
            launchCameraIntent()
        }
        val sendButton = findViewById<Button>(R.id.button)
        sendButton.setOnClickListener { // Navigate to VerifyFingerprintActivity
            handleClick()
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
                this@CreateRecipeActivity,
                HomePageActivity::class.java
            )
        startActivity(intent)
    }
    private fun launchCameraIntent() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        // Create a file for saving the captured image internally
        val storageDir = filesDir
        storageDir.mkdirs() // Create directory if it doesn't exist
        // Create a unique filename for the captured image
        val filename = "captured_image_${clickedImageButtonId}.jpg"
        capturedImageUri = File(storageDir, filename).absolutePath
        startActivityForResult(cameraIntent, CAMERA_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Log.d("MyActivity", "CAMERA OK") // Example logging
            val photo = data?.extras?.get("data") as? Bitmap
            val clickedButton = findViewById<ImageButton>(clickedImageButtonId)
            clickedButton?.setImageBitmap(photo)
            if (data != null) {
                // Write the captured image to the file
                try {
                    val outputStream = FileOutputStream(capturedImageUri)
                    photo?.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
                    outputStream.close()
                    Log.d("MyActivity", "SAVE OK") // Example logging
                    Log.d("MyActivity", "$capturedImageUri") // Example logging
                    // Image saved successfully
                } catch (e: Exception) {
                    // Handle exception if writing fails
                    e.printStackTrace()
                }
            }
        }
    }
    fun handleClick() {
        Log.d("MyActivity", "Homepage") // Example logging
        val intent: Intent = Intent(this@CreateRecipeActivity, HomePageActivity::class.java)
        startActivity(intent)
    }
    companion object {
        private const val CAMERA_REQUEST = 1888
    }
}
