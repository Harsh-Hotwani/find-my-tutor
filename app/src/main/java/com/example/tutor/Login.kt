package com.example.tutor

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutor.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private val binding:ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.signupbuttonlogin.setOnClickListener{
            Toast.makeText(this, "heloow waiting?", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,Registration1::class.java)
            startActivity(intent)
            finish()
        }
        binding.loginbutton.setOnClickListener{
            Toast.makeText(this, "heloow waiting?", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}