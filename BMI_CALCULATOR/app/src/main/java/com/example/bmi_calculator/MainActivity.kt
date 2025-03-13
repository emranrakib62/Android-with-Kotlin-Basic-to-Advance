package com.example.bmi_calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bmi_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBtn.setOnClickListener {
            val heightStr = binding.heightInput.text.toString().trim()
            val weightStr = binding.weightInput.text.toString().trim()

            // Validate input fields
            if (heightStr.isEmpty() || weightStr.isEmpty()) {
                Toast.makeText(this, "Please enter both height and weight", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val weight = weightStr.toFloat() // Weight in kg
                var heightFeet = heightStr.toFloat() // Assuming user enters height in feet only

                // Convert height from feet to meters
                val heightMeters = heightFeet * 0.3048f

                // BMI Calculation
                val bmi = weight / (heightMeters * heightMeters)

                // Display result
                binding.resultText.text = "BMI: %.2f".format(bmi)
                binding.resultText.visibility = android.view.View.VISIBLE // Make text visible
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid input! Please enter numeric values.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
