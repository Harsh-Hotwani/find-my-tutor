package com.example.tutor

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.tutor.databinding.ActivityRegistration2Binding
import com.example.tutor.databinding.ActivityRegistration3Binding

class Registration3 : AppCompatActivity() {
    private val binding: ActivityRegistration3Binding by lazy {
        ActivityRegistration3Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar!!.hide()

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        val phoneNumber = intent.getStringExtra("phone_number")
        val location = intent.getStringExtra("location")
        val role = intent.getStringExtra("role")
        



// Assuming you have a list of education options
        val educationList = arrayOf("Bachelor's Degree", "Master's Degree", "PhD", "Diploma", "High School", "Others")
// Create an ArrayAdapter to provide data to the AutoCompleteTextView
        val adapteredu = ArrayAdapter(this, R.layout.simple_list_item_1, educationList)
// Get a reference to the AutoCompleteTextView from your layout using its ID
        val autoCompleteTextViewEducation = binding.selectEdu
// Set the adapter to the AutoCompleteTextView
        autoCompleteTextViewEducation.setAdapter(adapteredu)


        // Assuming you have a list of subjects of interest
        val subjectsList = arrayOf(
            "Computer Science",
            "Engineering",
            "Mathematics",
            "Physics",
            "Biology",
            "Chemistry",
            "Literature",
            "History",
            "Art",
            "Music",
            "Sports",
            "Health",
            "Business",
            "Finance",
            "Marketing",
            "Languages",
            "Others"
        )
        val adaptersub = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjectsList)
        val autoCompleteTextViewSubject = binding.subjectOfInterest
        autoCompleteTextViewSubject.setAdapter(adaptersub)


        val platform = arrayOf("home","on center")
        val adapterPlatform = ArrayAdapter(this, android.R.layout.simple_list_item_1, platform)
        val autoCompleteTextViewPlatform = binding.tutorFormat
        autoCompleteTextViewPlatform.setAdapter(adapterPlatform)

        binding.finalSubmit.setOnClickListener{
            val education = binding.selectEdu.text.toString()
            val subjecto = binding.subjectOfInterest.toString()
            val platform = binding.tutorFormat.toString()
            val additionalinfo = binding.editTextAddInfo.text.toString()
            val data = "Email: $email\nPassword: $password\nPhone Number: $phoneNumber\nLocation: $location\nRole: $role\neducation: $education"
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        }
        // firebase registration
        

    }
}