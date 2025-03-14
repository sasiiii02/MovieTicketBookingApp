package com.example.movieticketbookingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.movieticketbookingapp.MovieListFragment
import com.example.movieticketbookingapp.SearchFragment
import com.example.movieticketbookingapp.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class movieList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        // Load MovieListFragment by default
        if (savedInstanceState == null) {
            loadFragment(MovieListFragment())
        }

        // Handle Bottom Navigation Clicks
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> loadFragment(MovieListFragment())
                R.id.nav_ticket -> loadFragment(SearchFragment())
                R.id.nav_user -> loadFragment(ProfileFragment())
            }
            true
        }
    }

    // Function to load fragments
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
