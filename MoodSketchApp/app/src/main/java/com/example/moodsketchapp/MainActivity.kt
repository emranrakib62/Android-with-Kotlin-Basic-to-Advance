package com.example.moodsketchapp



import android.graphics.Bitmap
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var moodSpinner: Spinner
    private lateinit var promptText: TextView
    private lateinit var drawingView: DrawingView
    private lateinit var saveButton: Button

    private val moodPrompts = mapOf(
        "Happy" to listOf("Draw your happy place", "Sketch a sun or rainbow"),
        "Sad" to listOf("Draw your feelings", "Sketch a rainy scene"),
        "Anxious" to listOf("Draw what calms you", "Sketch your thoughts"),
        "Energetic" to listOf("Draw a burst of color", "Sketch movement")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moodSpinner = findViewById(R.id.mood_spinner)
        promptText = findViewById(R.id.prompt_text)
        drawingView = findViewById(R.id.drawing_view)
        saveButton = findViewById(R.id.save_button)

        moodSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            moodPrompts.keys.toList()
        )

        moodSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                val mood = parent.getItemAtPosition(position).toString()
                val prompts = moodPrompts[mood]
                promptText.text = prompts?.random()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        saveButton.setOnClickListener {
            val bitmap: Bitmap = drawingView.getBitmap()
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
            val filename = "MoodSketch_$timeStamp.png"
            val stream = openFileOutput(filename, MODE_PRIVATE)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.close()
            Toast.makeText(this, "Sketch saved locally!", Toast.LENGTH_SHORT).show()
        }
    }
}
