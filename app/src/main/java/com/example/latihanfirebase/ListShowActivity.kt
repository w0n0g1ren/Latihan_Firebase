package com.example.latihanfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ListShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_show)

        val extra = intent.getStringExtra("nama")
        val extra2 = intent.getStringExtra("umur")

        val textview = findViewById<TextView>(R.id.tvnama2).apply {
            text = extra
        }

        val textview2 = findViewById<TextView>(R.id.tvumur2).apply {
            text = extra2
        }

    }
}