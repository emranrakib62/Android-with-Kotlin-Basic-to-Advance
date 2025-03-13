package com.example.appuiandclickanotheractivity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appuiandclickanotheractivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

lateinit var  binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()
        var intent=Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent)
        }
    }
}