package com.example.ketevan_mdzinarishvili_6

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ResourceRecyclerAdapter (private val resources: List<Resource>):
    RecyclerView.Adapter<ResourceViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.resource_item, parent, false)
        return ResourceViewHolder(itemView);
    }

    override fun getItemCount() = resources.size

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int) {
        holder.setData(resources[position])
        holder.containerView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("id", resources[position]?.id)
            holder.itemView.context.startActivity(intent)
        }
    }
}