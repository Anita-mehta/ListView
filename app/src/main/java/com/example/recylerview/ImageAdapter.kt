package com.example.recylerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import java.security.AccessController.getContext

class ImageAdapter(var context: Context,private  val mlist: List<dataItemView>):RecyclerView.Adapter<ImageAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.designlayout, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItemView= mlist[position]
        //set the image to the imageview from our itemholder class
        holder.imageView.setImageResource(dataItemView.image1)
        holder.image2.setImageResource(dataItemView.image2)

        //set the text to the textview from itemholder class
        holder.textView.text=dataItemView.text
        holder.textview1.text=dataItemView.text1
       // holder.textView.setOnClickListener {(holder.textView.text.setTextColor(Color.GREEN))} // click event
   //holder.textView.setOnClickListener {
       holder.textView.setOnClickListener(View.OnClickListener {
           val model=mlist.get(position)
           var name:String=model.text

           val intent = Intent(context, About::class.java).apply {
               putExtra("text",name)
           }
           context.startActivity(intent)
       })
    }


    override fun getItemCount(): Int {
        return mlist.size
    }
    class ViewHolder(ItemView:View) :RecyclerView.ViewHolder(ItemView){
        val imageView:  ImageView=itemView.findViewById(R.id.img1)
        val image2 :ImageView=itemView.findViewById(R.id.img2)
        val textView: TextView = itemView.findViewById(R.id.txt1)
        val textview1 :TextView=itemView.findViewById(R.id.txt2)

    }

}