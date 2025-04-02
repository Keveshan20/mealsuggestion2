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


class MealSuggestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // changed layout file

        val textView = findViewById<TextView>(R.id.textView2)
        val resetButton: Button = findViewById(R.id.button)
        val timeOfDayGroup: RadioGroup = findViewById(R.id.radioGroup)
        val timeOfDay = intent.getStringExtra("TIME_OF_DAY")

        val mealSuggestion = when (timeOfDay) {
            "2131231084" -> "Eggs and toast with bacon"
            "Mid-morning" -> "Fruit salad"
            "Afternoon" -> "Chicken wraps"
            "Mid-afternoon" -> "Cake"
            "Dinner" -> "Chicken Pasta"
            "After Dinner" -> "Ice cream"
            else -> "Invalid selection. Please go back and try again."
        }
        textView.text = mealSuggestion

        resetButton.setOnClickListener {
            timeOfDayGroup.clearCheck()
            val suggestionTextView: TextView = findViewById(R.id.textView2)
            suggestionTextView.text = "" // Clear the suggestion
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}