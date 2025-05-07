package com.example.class16

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.class16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bamboSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Bamboo Recommended: On", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Bamboo Recommended: Off", Toast.LENGTH_SHORT).show()
            }
        }


        var isPaymentSelected = false

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->

            isPaymentSelected = when (checkedId) {
                R.id.cash -> true
                R.id.card -> true
                else -> false
            }
        }



        binding.submit.setOnClickListener {

            val name = binding.nameedit.text.toString().trim()


            if (name.isEmpty()) {
                binding.nameedit.error = "Name field is required"
            } else if (!isPaymentSelected) {
                Toast.makeText(this, "You have to select a payment option", Toast.LENGTH_SHORT).show()
            } else if (!binding.cheainfo.isChecked || !binding.cheakagree.isChecked) {
                Toast.makeText(this, "You need to agree to the terms", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(this, "Form Submitted Successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
