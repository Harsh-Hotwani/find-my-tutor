package com.example.tutor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tutor.databinding.ActivityRegistration1Binding

class Registration1 : AppCompatActivity() {
    private val binding:ActivityRegistration1Binding by lazy {
        ActivityRegistration1Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.button3.setOnClickListener{
            startActivity(Intent(this,Registration2::class.java))
        }
    }
}