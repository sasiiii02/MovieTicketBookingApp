package com.example.movieticketbookingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SeatSelection : AppCompatActivity() {

    private lateinit var dateRecyclerView: RecyclerView
    private lateinit var dateAdapter: DateAdapter
    private val dateList = mutableListOf<DateModel>()

    private lateinit var timeRecyclerView: RecyclerView
    private lateinit var timeAdapter: TimeAdapter
    private val timeList = mutableListOf<TimeModel>()

    private lateinit var seatRecyclerView: RecyclerView
    private lateinit var seatAdapter: SeatAdapter
    private val seatList = mutableListOf<SeatModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val buyTicket = findViewById<Button>(R.id.buyTicket)
        buyTicket.setOnClickListener {
            val intent = Intent(this,Payment::class.java)
            startActivity(intent)
        }

        // Initialize Date RecyclerView
        dateRecyclerView = findViewById(R.id.recyclerViewDate)
        dateList.addAll(
            listOf(
                DateModel("15", "Fri"),
                DateModel("16", "Sat"),
                DateModel("17", "Sun"),
                DateModel("18", "Mon"),
                DateModel("19", "Tue")
            )
        )
        val back = findViewById<ImageView>(R.id.backButton)
        back.setOnClickListener {
            finish() // This will close MovieDetailsActivity and return to the previous screen
        }


        dateAdapter = DateAdapter(dateList) { selectedDate ->
            Toast.makeText(this, "Selected Date: ${selectedDate.date}", Toast.LENGTH_SHORT).show()
        }

        dateRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        dateRecyclerView.adapter = dateAdapter

        // Initialize Time RecyclerView
        timeRecyclerView = findViewById(R.id.recyclerViewTime)
        timeList.addAll(
            listOf(
                TimeModel("10:00 AM"),
                TimeModel("1:00 PM"),
                TimeModel("4:00 PM"),
                TimeModel("7:00 PM"),
                TimeModel("10:00 PM")
            )
        )

        timeAdapter = TimeAdapter(timeList) { selectedTime ->
            Toast.makeText(this, "Selected Time: ${selectedTime.time}", Toast.LENGTH_SHORT).show()
        }

        timeRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        timeRecyclerView.adapter = timeAdapter

        // Initialize Seat RecyclerView
        seatRecyclerView = findViewById(R.id.recyclerViewSeats)
        seatList.addAll(generateSeats())

        seatAdapter = SeatAdapter(seatList) { selectedSeat ->
            Toast.makeText(this, "Selected Seat: ${selectedSeat.seatNumber}", Toast.LENGTH_SHORT).show()
        }

        seatRecyclerView.layoutManager = GridLayoutManager(this, 5) // 5 seats per row
        seatRecyclerView.adapter = seatAdapter
    }

    private fun generateSeats(): List<SeatModel> {
        val seats = mutableListOf<SeatModel>()
        val rows = listOf("A", "B", "C", "D", "E") // Rows
        for (row in rows) {
            for (num in 1..5) { // 5 seats per row
                seats.add(SeatModel("$row$num"))
            }
        }
        return seats
    }
}
