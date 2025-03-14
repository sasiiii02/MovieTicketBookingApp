package com.example.movieticketbookingapp.fragments

import Movie
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieticketbookingapp.MovieAdapter
import com.example.movieticketbookingapp.R

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewNowShowing)
        val recyclerView2 = view.findViewById<RecyclerView>(R.id.recyclerViewUpcoming)

        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Now Showing Movies
        val nowShowingMovies = listOf(
            Movie("The Batman", "A thrilling Batman adventure.", R.drawable.batman_poster, "Action", 8.5, "2h 56m", "2022-03-04"),
            Movie("Spider-Man", "A journey through space and time.", R.drawable.spiderman_poster, "Adventure", 8.2, "2h 28m", "2021-12-17"),
            Movie("Moana", "A dream within a dream.", R.drawable.moana_poster, "Animation", 7.9, "1h 47m", "2016-11-23")
        )

        // Upcoming Movies
        val upcomingMovies = listOf(
            Movie("Avengers: Secret Wars", "The next big Marvel crossover event.", R.drawable.batman_poster, "Action", 0.0, "TBA", "2026-05-07"),
            Movie("Avatar 3", "James Cameron's sci-fi epic continues.", R.drawable.spiderman_poster, "Sci-Fi", 0.0, "TBA", "2025-12-19"),
            Movie("Black Panther 3", "Wakanda rises again.", R.drawable.moana_poster, "Action", 0.0, "TBA", "2026-11-06")
        )

        recyclerView.adapter = MovieAdapter(requireContext(), nowShowingMovies)
        recyclerView2.adapter = MovieAdapter(requireContext(), upcomingMovies)

        return view
    }
}
