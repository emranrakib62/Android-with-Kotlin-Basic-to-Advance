package com.example.clickevent

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clickevent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    binding.batmanlogo.setOnClickListener {

    binding.textview.text="welcome to kotlin"
}

    }
}