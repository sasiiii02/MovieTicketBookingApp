package com.example.movieticketbookingapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SeatAdapter(
    private val seatList: List<SeatModel>,
    private val onSeatSelected: (SeatModel) -> Unit
) : RecyclerView.Adapter<SeatAdapter.SeatViewHolder>() {

    private val selectedSeats = mutableSetOf<Int>()  // Store selected seat positions

    inner class SeatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val seatText: TextView = itemView.findViewById(R.id.seatTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_seat, parent, false)
        return SeatViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeatViewHolder, position: Int) {
        val seat = seatList[position]
        holder.seatText.text = seat.seatNumber

        // Change UI based on selection
        if (selectedSeats.contains(position)) {
            holder.seatText.setBackgroundResource(R.drawable.seat_selected_bg)
            holder.seatText.setTextColor(Color.WHITE)
        } else {
            holder.seatText.setBackgroundResource(R.drawable.seat_unselected_bg)
            holder.seatText.setTextColor(Color.WHITE)
        }

        holder.itemView.setOnClickListener {
            if (selectedSeats.contains(position)) {
                selectedSeats.remove(position)  // Deselect if already selected
            } else {
                selectedSeats.add(position)  // Select new seat
            }
            notifyItemChanged(position)
            onSeatSelected(seat)
        }
    }

    override fun getItemCount(): Int = seatList.size
}
