package com.example.movieticketbookingapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DateAdapter(
    private val dateList: List<DateModel>,
    private val onDateSelected: (DateModel) -> Unit
) : RecyclerView.Adapter<DateAdapter.DateViewHolder>() {

    private var selectedPosition = -1

    inner class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateText: TextView = itemView.findViewById(R.id.dateText)
        val dayText: TextView = itemView.findViewById(R.id.dayText)
        val dateLayout: LinearLayout = itemView.findViewById(R.id.dateLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_date, parent, false)
        return DateViewHolder(view)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        val date = dateList[position]

        holder.dateText.text = date.date
        holder.dayText.text = date.day

        // Update UI based on selection
        if (position == selectedPosition) {
            holder.dateLayout.setBackgroundResource(R.drawable.date_selected_bg)
            holder.dateText.setTextColor(Color.WHITE)
            holder.dayText.setTextColor(Color.WHITE)
        } else {
            holder.dateLayout.setBackgroundResource(R.drawable.date_unselected_bg)
            holder.dateText.setTextColor(Color.GRAY)
            holder.dayText.setTextColor(Color.GRAY)
        }

        holder.itemView.setOnClickListener {
            val previousSelected = selectedPosition
            selectedPosition = position
            notifyItemChanged(previousSelected)
            notifyItemChanged(selectedPosition)

            onDateSelected(date)
        }
    }

    override fun getItemCount(): Int = dateList.size
}
