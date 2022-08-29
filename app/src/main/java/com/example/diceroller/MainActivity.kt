package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceImageView = findViewById<ImageView>(R.id.imageView)
        diceImageView.setImageResource(R.drawable.dice_1)

        val rollButton = findViewById<Button>(R.id.button)
        val dice = Dice(6)

        rollButton.setOnClickListener {
            val result = dice.roll()
            diceImageView.contentDescription = result.toString()

            val imageResource = when (result) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.dice_6
            }
            diceImageView.setImageResource(imageResource)
        }


    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}