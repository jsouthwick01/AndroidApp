package com.example.livelabdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.livelabdemo.adapter.ItemAdapter
import com.example.livelabdemo.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = DataSource().loadAffirmations()
        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerview.adapter = ItemAdapter(this, myDataset)

        recyclerview.setHasFixedSize(true)
    }
}