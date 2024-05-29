package com.example.satumeja.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.satumeja.R
import com.example.satumeja.database.DatabaseHelper
//import com.example.satumeja.database.SchoolDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowRoomDataActivity : ComponentActivity() {
//    private lateinit var schoolDao: SchoolDao
    private lateinit var textviewSchoolName: TextView
    private lateinit var textviewSchoolEmail: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.statistik)
        val homeButton = findViewById<ImageButton>(R.id.imageView6)
        homeButton.setOnClickListener {
            navigateToHomeActivity()
        }
        // Get an instance of DAOs
        val database = DatabaseHelper.getInstance(this);
//        schoolDao = database.schoolDao();

        // Load and display data in a coroutine
        CoroutineScope(Dispatchers.IO).launch {
            // Load data from School and UserData tables
//            val school = schoolDao.getSchools() // Assuming a getSchool() method
//            val userData = schoolDao.getAllUsers() // Assuming a getUserData() method

            runOnUiThread {
//                textviewSchoolName.text = school.schoolName;
//                textviewSchoolEmail.text = school.email;
            }
//            if (userData.isNotEmpty()) {
//                runOnUiThread {
//                    // Update UI to display a list of users
//                    val userListView = findViewById<ListView>(R.id.user_list); // Get the ListView
//                    val userAdapter = UserAdapter(this@ShowRoomDataActivity, userData) // Create the adapter
//                    userListView.adapter = userAdapter; // Set the adapter for the ListView
//
//                }
//            }
        };
    }
    private fun navigateToHomeActivity() {
        Log.d("MyActivity", "Click Home") // Example logging
        val intent: Intent =
            Intent(
                this@ShowRoomDataActivity,
                HomePageActivity::class.java
            )
        startActivity(intent)
    }
}
