package com.example.movieticketbookingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_details)

        // Initialize views
        val movieTitle = findViewById<TextView>(R.id.movie_title)
        val movieDescription = findViewById<TextView>(R.id.movie_description)
        val movieImage = findViewById<ImageView>(R.id.movie_image)
        val movieGenre = findViewById<TextView>(R.id.movie_type)
        val movieRating = findViewById<TextView>(R.id.movie_rating)
        val movieDuration = findViewById<TextView>(R.id.movie_duration)
        val movieReleaseDate = findViewById<TextView>(R.id.movie_release_date)
        val buyTicket = findViewById<Button>(R.id.buyTicket)

        buyTicket.setOnClickListener{
            val intent = Intent(this,SeatSelection::class.java)
            startActivity(intent)

        }


        // Get data from Intent
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val imageResId = intent.getIntExtra("imageResId", 0)
        val genre = intent.getStringExtra("genre")
        val rating = intent.getDoubleExtra("rating", 0.0)
        val duration = intent.getStringExtra("duration")
        val releaseDate = intent.getStringExtra("releaseDate")

        // Set values
        movieTitle.text = title
        movieDescription.text = description
        movieImage.setImageResource(imageResId)
        movieGenre.text = "Genre: $genre"
        movieRating.text = "⭐ $rating/5"
        movieDuration.text = "Duration: $duration"
        movieReleaseDate.text = "Release Date: $releaseDate"
    }
}
