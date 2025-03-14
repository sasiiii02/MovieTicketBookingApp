package com.example.movieticketbookingapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_profile)


        val intent=intent
        val textView3 = findViewById<TextView>(R.id.textView3)
        val textView5 = findViewById<TextView>(R.id.textView5)
        val textView7 = findViewById<TextView>(R.id.textView7)


        val name = intent.getStringExtra("User_Name")
        textView3.text ="$name"
        val email = intent.getStringExtra("Email")
        textView5.text ="$email"
        val phone = intent.getStringExtra("Phone")
        textView7.text ="$phone"




    }
}