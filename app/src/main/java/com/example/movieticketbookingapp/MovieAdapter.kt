package com.example.movieticketbookingapp

import Movie
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val context: Context, private val movieList: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val movieImage: ImageView = view.findViewById(R.id.movie_poster)
        val movieTitle: TextView = view.findViewById(R.id.movie_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.movieTitle.text = movie.title
        holder.movieImage.setImageResource(movie.imageResId)

        // Handle click event to open MovieDetailsActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(context, MovieDetailsActivity::class.java).apply {
                putExtra("title", movie.title)
                putExtra("description", movie.description)
                putExtra("imageResId", movie.imageResId)
                putExtra("genre", movie.genre)
                putExtra("rating", movie.rating)
                putExtra("duration", movie.duration)
                putExtra("releaseDate", movie.releaseDate)
            }
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = movieList.size
}
