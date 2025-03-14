package com.example.movieticketbookingapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TimeAdapter(
    private val timeList: List<TimeModel>,
    private val onTimeSelected: (TimeModel) -> Unit
) : RecyclerView.Adapter<TimeAdapter.TimeViewHolder>() {

    private var selectedPosition = -1

    inner class TimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val timeText: TextView = itemView.findViewById(R.id.timeTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_time, parent, false)
        return TimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) {
        val time = timeList[position]

        holder.timeText.text = time.time

        // Update UI based on selection
        if (position == selectedPosition) {
            holder.timeText.setBackgroundResource(R.drawable.time_selected_bg)
            holder.timeText.setTextColor(Color.WHITE)
        } else {
            holder.timeText.setBackgroundResource(R.drawable.time_unselected_bg)
            holder.timeText.setTextColor(Color.GRAY)
        }

        holder.itemView.setOnClickListener {
            val previousSelected = selectedPosition
            selectedPosition = position
            notifyItemChanged(previousSelected)
            notifyItemChanged(selectedPosition)

            onTimeSelected(time)
        }
    }

    override fun getItemCount(): Int = timeList.size
}
