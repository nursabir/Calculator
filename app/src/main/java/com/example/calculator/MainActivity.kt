package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val calc: Calc = Calc()
    var text: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text_input)

        val numbers: Array<View> = arrayOf(
            findViewById(R.id.zero),
            findViewById(R.id.one),
            findViewById(R.id.two),
            findViewById(R.id.three),
            findViewById(R.id.four),
            findViewById(R.id.five),
            findViewById(R.id.six),
            findViewById(R.id.seven),
            findViewById(R.id.eight),
            findViewById(R.id.nine)
        )
        val actions: Array<View> = arrayOf(
            findViewById(R.id.equals),
            findViewById(R.id.plus),
            findViewById(R.id.minus),
            findViewById(R.id.multiply),
            findViewById(R.id.division)
        )
        for (i in 0..9) {
            numbers[i].setOnClickListener {
                calc.onNumPressed(numbers[i].id)
                text?.setText(calc.input)

            }
        }
        for (i in 0..4) {
            actions[i].setOnClickListener {
                calc.onActionPressed(actions[i].id)
                text?.setText(calc.input)
            }
        }
        val clear: Button = findViewById(R.id.clear_text)
        clear.setOnClickListener {
            calc.input = ""
            text?.setText(calc.input)
        }

    }

}