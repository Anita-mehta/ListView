package com.example.recylerview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview1)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<dataItemView>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(dataItemView(R.drawable.ic_baseline_directions_run_24,R.drawable.ic_baseline_emoji_people_24, "Hi" ,"Everyone"+ i))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = ImageAdapter(this,data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }
}