package com.simongeorgeasmar.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.simongeorgeasmar.affirmations.R
import com.simongeorgeasmar.affirmations.model.Affirmation

//context has information on how to resolve the string resources and other info about the app
class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    //view holder holds references to individual views within a list item layout
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceID)
        holder.imageView.setImageResource(item.imageResourceID)
    }

    override fun getItemCount() = dataset.size


}