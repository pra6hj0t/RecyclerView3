package com.example.recyclerview2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Animal_Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContentView(R.layout.activity_animal_info)

        val name = findViewById<TextView>(R.id.info_animal_name)
        val image = findViewById<ImageView>(R.id.info_animal_img)
        val about = findViewById<TextView>(R.id.info_animal_about)


        val aImage = intent.getIntExtra("animalImage",R.drawable.pic1)
        val aNumber = intent.getStringExtra("animalNumber")
        val aAbout = intent.getStringExtra("animalAbout")

        name.text = aNumber
        image.setImageResource(aImage)
        about.text = aAbout
    }
}