package com.example.movieticketbookingapp

data class DateModel(
    val date: String,  // e.g., "March 15"
    val day: String,   // e.g., "Fri"
    var isSelected: Boolean = false
)
