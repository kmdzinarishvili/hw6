package com.example.ketevan_mdzinarishvili_6

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ResourceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val colorView: View = itemView.findViewById(R.id.color);
    private val nameTextView: TextView = itemView.findViewById(R.id.name);
    private val pantoneValueTextView: TextView = itemView.findViewById(R.id.pantoneValue);
    private val yearTextView: TextView = itemView.findViewById(R.id.year);
    val containerView: ConstraintLayout = itemView.findViewById(R.id.container)

    fun setData(resource: Resource){
        colorView.setBackgroundColor(Color.parseColor(resource.color));
        nameTextView.text = resource.name;
        pantoneValueTextView.text = resource.pantoneValue;
        yearTextView.text = resource.year.toString();
    }
}
