package com.example.satumeja.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.satumeja.R
import java.io.File
import java.io.FileOutputStream

class ConfirmMenuActivity : Activity() {
    private var clickedImageButtonId: Int = 0
    private var capturedImageUri: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

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
        val yes_button = findViewById<Button>(R.id.yes_button)
        yes_button.setOnClickListener {
            navigateToConfirmActivity()
        }
        val no_button = findViewById<Button>(R.id.no_button)
        no_button.setOnClickListener {
            showReasonField()
        }
        val send_button = findViewById<Button>(R.id.send_button)
        send_button.setOnClickListener {
            navigateToConfirm2Activity()
        }
        val home_button = findViewById<ImageButton>(R.id.imageView6)
        home_button.setOnClickListener {
            navigateToHomeActivity()
        }
    }
    private fun navigateToConfirmActivity() {
        Log.d("MyActivity", "YES") // Example logging
        val intent: Intent =
            Intent(
                this@ConfirmMenuActivity,
                HomePageActivity::class.java
            )
        startActivity(intent)
    }
    private fun navigateToConfirm2Activity() {
        Log.d("MyActivity", "SEND") // Example logging
        val reasonField = findViewById<EditText>(R.id.edit_text_1).text.toString()
        Log.d("MyActivity", "Menu : $reasonField") // Example logging
         val intent: Intent =
            Intent(
                this@ConfirmMenuActivity,
                HomePageActivity::class.java
            )
        startActivity(intent)
    }
    private fun showReasonField() {
        Log.d("MyActivity", "NO") // Example logging
        val reasonField = findViewById<EditText>(R.id.edit_text_1)
        val sendButton = findViewById<Button>(R.id.send_button)
        reasonField.visibility = View.VISIBLE
        sendButton.visibility = View.VISIBLE
        val linearLayout = findViewById<LinearLayout>(R.id.line1)
        val yes_button = findViewById<Button>(R.id.yes_button)
        val no_button = findViewById<Button>(R.id.no_button)
        linearLayout.visibility = View.GONE
        yes_button.visibility = View.GONE
        no_button.visibility = View.GONE
    }
    private fun navigateToHomeActivity() {
        Log.d("MyActivity", "Click Home") // Example logging
        val intent: Intent =
            Intent(
                this@ConfirmMenuActivity,
                HomePageActivity::class.java
            )
        startActivity(intent)
    }
}
