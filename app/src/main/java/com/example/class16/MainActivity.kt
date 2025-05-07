package com.example.class16

import android.app.ProgressDialog.show
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.class16.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity :
    AppCompatActivity(), CompoundButton.OnCheckedChangeListener {


  lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding=ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)
binding.bamboSwitch.setOnCheckedChangeListener(this)

        binding.submit.setOnClickListener {
            
            var msg:String=binding.nameedit.text.toString().trim()
            show(msg)
        }


    }

    private fun show(msg: String) {

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

       if(isChecked){
           Toast.makeText(this,"chacked",Toast.LENGTH_SHORT).show()
       }else{
           Toast.makeText(this,"Not chacked",Toast.LENGTH_SHORT).show()
       }

    }


}