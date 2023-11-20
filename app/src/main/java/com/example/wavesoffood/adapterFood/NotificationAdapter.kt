package com.example.wavesoffood.adapterFood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.NotificationBottomFragment
import com.example.wavesoffood.databinding.FragmentNotificationBottomBinding
import com.example.wavesoffood.databinding.NotificationItemBinding

class NotificationAdapter(private var notifications : ArrayList<String>, private var notificationImages: ArrayList<Int>) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding = NotificationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding)
    }

    override fun getItemCount(): Int = notifications.size

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(notifications[position], notificationImages[position])
    }
    inner class NotificationViewHolder(private val binding: NotificationItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(notification: String, imageResource: Int) {
            binding.notificationTextView.text = notification
            binding.notificationImageView.setImageResource(imageResource)
        }

    }

}