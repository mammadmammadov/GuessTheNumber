package com.example.guessthenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.guessthenumber.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val result = intent.getBooleanExtra("result", false)
        Log.e("Mammad", result.toString())

        if(!result){
            binding.textViewResult.text = "You Lost!"
            binding.resultImage.setImageResource(R.drawable.sad)
        }

        else{
            binding.textViewResult.text = "You Won!"
            binding.resultImage.setImageResource(R.drawable.happy)
        }


        binding.btnRestart.setOnClickListener {
            startActivity(Intent(this@ResultActivity, GuessActivity::class.java))
            finish() //this method literally means that after I do the transition, if I wanna go back, this page won't exist there
        }

    }
}