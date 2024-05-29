package com.example.satumeja.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "satumeja.db"
        private const val DATABASE_VERSION = 1
        private var instance: DatabaseHelper? = null

        fun getInstance(context: Context): DatabaseHelper {
            if (instance == null) {
                instance = DatabaseHelper(context)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Create tables
        db.execSQL("CREATE TABLE school (" +
                "nama_sekolah TEXT NOT NULL PRIMARY KEY," +
                "email TEXT NOT NULL)")

        db.execSQL("CREATE TABLE user_data (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nisn TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "name TEXT NOT NULL," +
                "age INTEGER," +
                "schoolName TEXT NOT NULL," +
                "classes TEXT NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database schema changes if needed
        // (Example: Drop tables and recreate them in a new version)
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS school");
        db.execSQL("DROP TABLE IF EXISTS user_data");

        // Create tables again
        onCreate(db);
    }
    fun insertSchool(school: School) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("nama_sekolah", school.schoolName)
            put("email", school.email)
        }
        db.insert("school", null, values)
        db.close()
    }

    fun insertUserData(userData: UserData) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("nisn", userData.nisn)
            put("email", userData.email)
            put("name", userData.name)
            put("age", userData.age)
            put("schoolName", userData.schoolName)
            put("classes", userData.classes)
        }
        db.insert("user_data", null, values)
        db.close()
    }
    fun getAllSchools(): List<School> {
        val schools = mutableListOf<School>()
        val db = readableDatabase
        val cursor = db.query("school", null, null, null, null, null, null)
        while (cursor.moveToNext()) {
            val school = School(cursor.getString(0), cursor.getString(1))
            schools.add(school)
        }
        cursor.close()
        return schools
    }

    fun getAllUserData(): List<UserData> {
        val userDataList = mutableListOf<UserData>()
        val db = readableDatabase
        val cursor = db.query("user_data", null, null, null, null, null, null)
        while (cursor.moveToNext()) {
            val userData = UserData(
                cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5)
            )
            userDataList.add(userData)
        }
        cursor.close()
        return userDataList
    }
    fun updateSchoolEmail(oldEmail: String, newEmail: String) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("email", newEmail)
        }
        db.update("school", values, "email = ?", arrayOf(oldEmail))
        db.close()
    }
    fun deleteSchool(name: String) {
        val db = writableDatabase
        db.delete("school", "nama_sekolah = ?", arrayOf(name))
        db.close()
    }
}
