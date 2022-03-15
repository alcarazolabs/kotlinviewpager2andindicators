package com.example.kotlinviewpager2andindicators

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(
        private val personlist: List<Person> = listOf(),
        ) : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.imagePerson)
        val name : TextView = itemView.findViewById(R.id.tvName)


        init {
            image.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(itemView.context, "You clicked item position #${position+1}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.Pager2ViewHolder {

       return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.image.setImageResource(personlist[position].image)
        holder.name.text = personlist[position].name

    }

    override fun getItemCount(): Int {
        return personlist.size
    }



}