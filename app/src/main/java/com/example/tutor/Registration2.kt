package com.example.tutor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.example.tutor.databinding.ActivityRegistration1Binding
import com.example.tutor.databinding.ActivityRegistration2Binding

class Registration2 : AppCompatActivity() {
    private val binding:ActivityRegistration2Binding by lazy {
        ActivityRegistration2Binding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar!!.hide()

        val locationList = arrayOf("indore","bhopal","gwalior","jabalpur")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView = binding.listoflocation
        autoCompleteTextView.setAdapter(adapter)

        val roleList = arrayOf("student","teacher")
        val adapterRole = ArrayAdapter(this,android.R.layout.simple_list_item_1,roleList)
        val autoCompleteTextViewRole = binding.selectRole
        autoCompleteTextViewRole.setAdapter(adapterRole)

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        val phoneNumber = intent.getStringExtra("phone_number")

       binding.next2.setOnClickListener{

           val location = binding.listoflocation.text.toString()
           val role = binding.selectRole.text.toString()
//
//            // Combine the previous data with additional data
//            val combinedData = "$email, $password, $phoneNumber, $location"
//           Toast.makeText(this, combinedData, Toast.LENGTH_SHORT).show()
//            // Start the next activity or save the data to database
//            // For example:
            val intent = Intent(this,Registration3::class.java).apply {
                putExtra("email", email)
                putExtra("password", password)
                putExtra("phone_number", phoneNumber)
                putExtra("location",location)
                putExtra("role",role)
            }
           startActivity(intent)
        }
    }
}