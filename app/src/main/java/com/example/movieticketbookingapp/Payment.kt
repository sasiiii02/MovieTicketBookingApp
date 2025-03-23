package com.example.movieticketbookingapp

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment)
        val back = findViewById<ImageView>(R.id.back_button)
        back.setOnClickListener {
            finish() // This will close MovieDetailsActivity and return to the previous screen
        }


    }
}