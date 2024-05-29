package com.example.satumeja.database

data class School(
    val schoolName: String,
    val email: String
)

data class UserData(
    val nisn: String,
    val email: String,
    val name: String,
    val age: String,
    val schoolName: String,
    val classes: String
)