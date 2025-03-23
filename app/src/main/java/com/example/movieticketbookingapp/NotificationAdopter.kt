package com.example.movieticketbookingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotificationAdopter(private val groupList: List<Notification>) :
    RecyclerView.Adapter<NotificationAdopter.GroupViewHolder>() {

    class GroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDay: TextView = view.findViewById(R.id.tv_day)
        val tvTime: TextView = view.findViewById(R.id.tv_time)
        val tvGroupName: TextView = view.findViewById(R.id.tv_group_name)
        val tvDescription: TextView = view.findViewById(R.id.tv_description)
        val ivDelete: ImageView = view.findViewById(R.id.iv_dot)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notification, parent, false)
        return GroupViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val notification = groupList[position]
        holder.tvDay.text = notification.day
        holder.tvTime.text = notification.time
        holder.tvGroupName.text = notification.groupName
        holder.tvDescription.text = notification.description


    }

    override fun getItemCount(): Int = groupList.size
}
