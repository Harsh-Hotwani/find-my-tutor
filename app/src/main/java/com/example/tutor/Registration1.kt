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
            val email = binding.editTextTextEmailAddress2.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            val phoneNumber = binding.editTextPhone.text.toString()
            val intent = Intent(this, Registration2::class.java).apply {
                putExtra("email", email)
                putExtra("password", password)
                putExtra("phone_number", phoneNumber)
            }
            startActivity(intent)
        }
    }
}