package com.example.movieticketbookingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnBoardOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_board_one)

        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnSkip = findViewById<TextView>(R.id.btnSkip)
        btnSkip.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        btnNext.setOnClickListener{
            val intent = Intent(this, OnBoardTwo::class.java)
            startActivity(intent)
        }



    }
}