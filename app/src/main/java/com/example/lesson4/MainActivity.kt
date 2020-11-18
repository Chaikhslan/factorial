package com.example.lesson4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

private const val REQUEST = 1000

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadString()

        start_btn_name.setOnClickListener {
            val name = edit_text.text.toString()
            val age: String = edit_text2.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            startActivityForResult(intent, REQUEST)
            saveString()
        }
    }

    private fun loadString() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("key", null)
        answer.text = savedString
    }

    private fun saveString() {
        val textSave = edit_text2.text.toString()
        val ageInt = textSave?.toInt()
        var count: Double = 1.0
        for (i in 1..ageInt!!) {
            count *= i
        }
        answer.text = count.toString()

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putString("key", count.toString())
        }.apply()
    }


}

