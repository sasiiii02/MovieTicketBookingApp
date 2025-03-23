package com.example.movieticketbookingapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the ImageView and set the click listener
        val ivSettings = view.findViewById<ImageView>(R.id.ivSettings)
        ivSettings.setOnClickListener {
            // Create an intent to navigate to the Settings activity
            val intent = Intent(requireContext(), Settings::class.java)
            startActivity(intent)
        }
    }
}