package com.example.satumeja.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.satumeja.R
import com.example.satumeja.database.DatabaseHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RegisterUserActivity : ComponentActivity() {

//    private lateinit var schoolDao: SchoolDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_account)

        val database = DatabaseHelper.getInstance(this)
//        schoolDao = database.schoolDao()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            navigateToHomepageActivity()
        }

    }
    private fun navigateToHomepageActivity() {
        val nisn = findViewById<EditText>(R.id.edit_text_1).text.toString()
        val email = findViewById<EditText>(R.id.edit_text_2).text.toString()
        val name = findViewById<EditText>(R.id.edit_text_3).text.toString()
        val age = findViewById<EditText>(R.id.edit_text_4).text.toString()
        val schoolName = findViewById<EditText>(R.id.edit_text_5).text.toString()
        val classes = findViewById<EditText>(R.id.edit_text_6).text.toString()

//        val userData = UserData(
//            0, // id will be auto-generated
//            nisn,
//            email,
//            name,
//            age,
//            schoolName,
//            classes
//        )

        CoroutineScope(Dispatchers.IO).launch {
            try {
//                schoolDao.insertUserData(userData)
                withContext(Dispatchers.Main) {
                    // Show success message (e.g., Toast)
                    Toast.makeText(this@RegisterUserActivity, "User data saved successfully!", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    // Show error message (e.g., Toast)
                    Toast.makeText(this@RegisterUserActivity, "Error saving user data: ${e.message}", Toast.LENGTH_SHORT).show()
                    Log.d("MyActivity", "Error saving school data: ${e.message}") // Example logging
                }
            }
        }
        Log.d("MyActivity", "Registration Details: NISN: $nisn, Email: $email, Name: $name, Age: $age, School Name: $schoolName, Classes: $classes") // Log the details
        val intent = Intent(this@RegisterUserActivity, HomePageActivity::class.java)
        startActivity(intent)
    }
}
