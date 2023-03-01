package com.example.lab

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows user to roll dice and view the result
 *
 */
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button2)
        rollButton.setOnClickListener {
            rollDice()
        }
    }
    //Roll dice and update the text view.
    private fun rollDice()
    {
        //Create and roll die
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //Update the text view
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }

    }

/**
 * Dice class
 */
class Dice(private val numSides: Int) {
    fun roll():Int {
        return (1..numSides).random()
    }
}

