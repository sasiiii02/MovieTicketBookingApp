package com.example.movieticketbookingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        // Sample Data
        val notificationList = mutableListOf(
            Notification("Today", "10:30 AM", "Dune: Part Two", "Your booking for 'Dune: Part Two' at Grand Cinemas is confirmed."),
            Notification("Today", "12:00 PM", "Avatar 3", "Reminder: 'Avatar 3' starts in 1 hour at IMAX Theatre."),
            Notification("Yesterday", "08:45 PM", "John Wick 5", "Your seat upgrade for 'John Wick 5' is successful."),
            Notification("Yesterday", "07:15 PM", "Deadpool 3", "Flash Sale: Get 20% off on 'Deadpool 3' tickets for today!"),
            Notification("Today", "03:00 PM", "Mission Impossible 8", "Your refund for 'Mission Impossible 8' has been processed."),
            Notification("Yesterday", "06:30 PM", "Oppenheimer", "Special Screening Alert: 'Oppenheimer' Director’s Cut - Limited Seats!"),
            Notification("Today", "09:00 AM", "Spider-Man: Beyond the Spider-Verse", "Your booking for 'Spider-Man: Beyond the Spider-Verse' is confirmed."),
            Notification("Today", "02:45 PM", "The Batman 2", "Reminder: 'The Batman 2' starts at 3:30 PM at Dolby Atmos Theatre."),
            Notification("Yesterday", "05:00 PM", "Fast & Furious 11", "Exclusive Offer: Buy 1 Get 1 Free on 'Fast & Furious 11' tickets."),
            Notification("Today", "11:15 AM", "The Joker 2", "Your tickets for 'The Joker 2' have been successfully downloaded.")
        )


        // Set up RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = NotificationAdopter(notificationList)

        return view
    }
}
