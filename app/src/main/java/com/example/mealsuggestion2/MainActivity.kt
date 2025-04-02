package com.example.mealsuggestion2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.content.ContentValues.TAG

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        val suggestButton: Button = findViewById(R.id.button2)
        val resetButton: Button = findViewById(R.id.button) // Added reset button
        val timeOfDayGroup: RadioGroup = findViewById(R.id.radioGroup)

        suggestButton.setOnClickListener {
            val selectedId = timeOfDayGroup.checkedRadioButtonId
            Log.d(TAG, "ID = "+selectedId.toString())
            val timeOfDay = when (selectedId) {
               R.id.radioButton -> "2131231084"
                R.id.radioButton2 -> "Mid-morning"
                R.id.radioButton3-> "Afternoon"
                R.id.radioButton4 -> "Mid-afternoon"
                R.id.radioButton5 -> "Dinner"
                R.id.radioButton6-> "After Dinner"
                else -> null
            }
            Log.d(TAG, "ID after = "+timeOfDay.toString())

            if (timeOfDay != null) {
                val intent = Intent(this, MealSuggestionActivity::class.java)
                intent.putExtra("TIME_OF_DAY", timeOfDay)
                startActivity(intent)
            } else {
                val suggestionTextView: TextView = findViewById(R.id.textView2)
                suggestionTextView.text = "Please select a time of day."
            }
        }

        resetButton.setOnClickListener {
            timeOfDayGroup.clearCheck()
            val suggestionTextView: TextView = findViewById(R.id.textView2)
            suggestionTextView.text = "" // Clear the suggestion
        }

        // initially clear any suggestion in main activity
        val suggestionTextView: TextView = findViewById(R.id.textView2)
        suggestionTextView.text = ""
    }
}
