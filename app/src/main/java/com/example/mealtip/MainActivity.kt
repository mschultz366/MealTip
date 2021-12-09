package com.example.mealtip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var total: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cost: EditText = findViewById(R.id.txtNumber)
        val option: Spinner = findViewById(R.id.spnGroup)
        val calc: Button = findViewById(R.id.button)
        val out: TextView = findViewById(R.id.output)

        calc.setOnClickListener {
            val formattedOutput = DecimalFormat("$###,###.00")

            val mealCost = cost.text.toString().toDouble()
            val tipPercent = option.selectedItem.toString().toDouble()

            total = mealCost * tipPercent * .01
            val displayOutput = formattedOutput.format(total)

            out.text = "Give a tip of $displayOutput!"
        }
    }
}