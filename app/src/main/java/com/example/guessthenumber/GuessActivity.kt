package com.example.guessthenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.guessthenumber.databinding.ActivityGuessBinding
import kotlin.random.Random

class GuessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuessBinding

    private var generatedNumber = 0
    private var remainingGuesses = 5


    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityGuessBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        generatedNumber = Random.nextInt(1, 100)
        Log.e("number", generatedNumber.toString())



        binding.btnGuess.setOnClickListener {
            remainingGuesses--

            if (binding.editTextInput.text.toString().toInt() == generatedNumber) {
                val intent  = Intent(this@GuessActivity, ResultActivity::class.java)
                intent.putExtra("result", true)
                finish() //removes the fragment from backstage
                startActivity(intent)
                return@setOnClickListener //for not moving on to the next lines
            }

            else if (binding.editTextInput.text.toString().toInt() < generatedNumber) {
                binding.textViewHelp.text = "Increase"
                binding.textViewChances.text="$remainingGuesses"
            }

            else if (binding.editTextInput.text.toString().toInt() > generatedNumber) {
                binding.textViewHelp.text = "Decrease"
                binding.textViewChances.text="$remainingGuesses"
            }

            if (remainingGuesses == 0) {

                //we must create intent variable separately, then add that in it and finally startActivity()
                val intent = Intent(this@GuessActivity, ResultActivity::class.java)
                intent.putExtra("result", false)
                finish() //removes the fragment from backstage
                startActivity(intent)

            }

            binding.editTextInput.setText("")


        }
    }
}