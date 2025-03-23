package com.example.movieticketbookingapp

import Movie
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MovieListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        val profileIcon = view.findViewById<ImageView>(R.id.profileIcon)

        profileIcon.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, ProfileFragment())
            fragmentTransaction.addToBackStack(null) // Optional: Add the transaction to the back stack
            fragmentTransaction.commit()
        }




        // Initialize RecyclerViews
        val recyclerViewNowShowing = view.findViewById<RecyclerView>(R.id.recyclerViewNowShowing)
        val recyclerViewUpcoming = view.findViewById<RecyclerView>(R.id.recyclerViewUpcoming)

        recyclerViewNowShowing.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewUpcoming.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Now Showing Movies
        val nowShowingMovies = listOf(
            Movie("The Batman", "A thrilling Batman adventure where the Dark Knight battles new foes and uncovers a sinister conspiracy in Gotham. With a darker tone and a gripping mystery, it’s a must-watch for comic book lovers.", R.drawable.batman_poster, "Action", 8.5, "2h 56m", "2022-03-04"),
            Movie("Spider-Man", "Peter Parker swings back into action in this adventurous journey that takes him through space and time, confronting new villains and struggling to balance his superhero duties with his personal life.", R.drawable.spiderman_poster, "Adventure", 8.2, "2h 28m", "2021-12-17"),
            Movie("Moana", "In this Disney animated classic, a young Polynesian girl embarks on a daring voyage across the sea to save her island. Along the way, she discovers her true destiny and becomes the hero she was always meant to be.", R.drawable.moana_poster, "Animation", 7.9, "1h 47m", "2016-11-23"),
            Movie("Inception", "A mind-bending thriller directed by Christopher Nolan, where a skilled thief who specializes in extracting secrets from deep within the subconscious is given a chance to have his criminal record erased in exchange for implanting an idea into someone's mind.", R.drawable.inception_poster, "Sci-Fi", 8.8, "2h 28m", "2010-07-16"),
            Movie("The Matrix", "A groundbreaking film that challenges the boundaries of reality itself. A computer hacker discovers that the world around him is an illusion controlled by machines, and he must fight back to free humanity from their control.", R.drawable.matrix_poster, "Sci-Fi", 8.7, "2h 16m", "1999-03-31"),
            Movie("The Lion King", "Disney’s iconic animated film follows Simba, a young lion prince, on his journey from exile to reclaiming his rightful place as king of the Pride Lands, all while battling the dark forces of the world.", R.drawable.lionking_poster, "Animation", 8.5, "1h 28m", "1994-06-15"),
            Movie("Titanic", "A sweeping romance set against the backdrop of the infamous ship’s tragic voyage. Jack and Rose, two young lovers from different social classes, must fight to survive as the ship sinks into the icy waters of the Atlantic.", R.drawable.titanic_poster, "Romance", 7.8, "3h 14m", "1997-12-19"),
            Movie("Jurassic Park", "A groundbreaking adventure that brings dinosaurs back to life through genetic engineering. But things go terribly wrong, and the scientists must survive the terrifying prehistoric creatures that now rule the island.", R.drawable.jurassicpark_poster, "Adventure", 8.1, "2h 7m", "1993-06-11")
        )

        // Upcoming Movies
        val upcomingMovies = listOf(
            Movie("Avengers: Secret Wars", "The next big Marvel crossover event where multiple universes collide, heroes and villains from different realities must unite to face a common enemy in the battle for the fate of all existence.", R.drawable.avenger_poster, "Action", 0.0, "TBA", "2026-05-07"),
            Movie("Avatar 3", "James Cameron’s sci-fi epic continues with new adventures on Pandora. The family of Jake Sully and Neytiri face new challenges as they defend their home from external threats and explore uncharted territories.", R.drawable.avatar_poster, "Sci-Fi", 0.0, "TBA", "2025-12-19"),
            Movie("Black Panther 3", "T'Challa's legacy continues as new challenges arise in Wakanda, while the kingdom faces new threats from both within and outside their borders. The hero's journey extends beyond the throne in this anticipated Marvel film.", R.drawable.backpanther_poster, "Action", 0.0, "TBA", "2026-11-06"),
            Movie("The Flash", "Barry Allen, the fastest man alive, races against time and multiple versions of himself in an attempt to save the world from a time-warping villain. His speed and determination will be put to the ultimate test.", R.drawable.flash_poster, "Action", 0.0, "TBA", "2025-06-10"),
            Movie("Fantastic Beasts 4", "New magical threats emerge as the wizarding world faces a dark future. Fantastic creatures, ancient spells, and the wizarding world’s finest face challenges that could change their world forever.", R.drawable.fantasticbeats_poster, "Fantasy", 0.0, "TBA", "2026-07-22"),
            Movie("Mission: Impossible 8", "Ethan Hunt’s mission takes him to dangerous new territories where betrayal and suspense fill every moment. A race against time ensues as he uncovers a web of deception that could destroy everything he holds dear.", R.drawable.missionimpossible_poster, "Action", 0.0, "TBA", "2027-01-18"),
            Movie("Jurassic World: Dominion", "Dinosaurs rule the earth once again, and humanity must find a way to coexist with these ancient creatures. New alliances are formed, but the threat of extinction looms larger than ever.", R.drawable.jurassicworld_poster, "Adventure", 0.0, "TBA", "2026-08-11"),
            Movie("The Flash 2", "Barry Allen’s journey continues in this action-packed sequel, where the timeline threatens to spiral out of control. A new crisis looms, and the speed force may not be enough to save him this time.", R.drawable.flash2_poster, "Action", 0.0, "TBA", "2027-02-15")
        )

        // Set adapters separately
        recyclerViewNowShowing.adapter = MovieAdapter(requireContext(), nowShowingMovies)
        recyclerViewUpcoming.adapter = MovieAdapter(requireContext(), upcomingMovies)

        return view
    }
}
