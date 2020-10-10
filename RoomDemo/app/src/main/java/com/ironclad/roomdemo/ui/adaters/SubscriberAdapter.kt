package com.ironclad.roomdemo.ui.adaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ironclad.roomdemo.R
import com.ironclad.roomdemo.data.model.Subscriber
import com.ironclad.roomdemo.databinding.SubscriberListItemBinding

class SubscriberAdapter(
    private val clickListener: (Subscriber) -> Unit
) :
    RecyclerView.Adapter<SubscriberAdapter.SubscriberViewHolder>() {

    class SubscriberViewHolder(val binding: SubscriberListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(subscriber: Subscriber, clickListener: (Subscriber) -> Unit) {
            binding.tvName.text = subscriber.name
            binding.tvEmail.text = subscriber.email
            binding.llSub.setOnClickListener {
                clickListener(subscriber)
            }
        }

    }

    private val subscribers = ArrayList<Subscriber>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: SubscriberListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.subscriber_list_item, parent, false)
        return SubscriberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubscriberViewHolder, position: Int) {
        holder.bind(subscribers[position], clickListener)
    }

    override fun getItemCount(): Int = subscribers.size

    fun setList(subscribersList: List<Subscriber>) {
        subscribers.clear()
        subscribers.addAll(subscribersList)
    }
}