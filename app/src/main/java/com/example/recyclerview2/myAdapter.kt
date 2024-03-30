package com.example.recyclerview2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel
import org.w3c.dom.Text

class myAdapter(val context :Activity,var animalArrayList: ArrayList<Animals>):
RecyclerView.Adapter<myAdapter.MyViewHolder>(){

    lateinit var myListener: onItemClickListener

    interface onItemClickListener{
                fun onItemClick(position: Int)
    }

    fun setItemClickListener(listener: onItemClickListener) {

        myListener = listener

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(view,myListener)
    }

    override fun getItemCount(): Int {
        return animalArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem =animalArrayList[position]

        holder.animalimg.setImageResource(currentItem.animalImg)
        holder.animalname.text = currentItem.animalName
    }

    class MyViewHolder(itemView: View,listener: onItemClickListener) :RecyclerView.ViewHolder(itemView) {

        val animalimg = itemView.findViewById<ShapeableImageView>(R.id.animalImg)
        val animalname = itemView.findViewById<TextView>(R.id.animalName)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }
}