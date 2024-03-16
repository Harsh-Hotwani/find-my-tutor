package com.example.tutor

import android.R
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.tutor.databinding.ActivityRegistration2Binding
import com.example.tutor.databinding.ActivityRegistration3Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class Registration3 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var usersRef: DatabaseReference
    private lateinit var storage: FirebaseStorage
    private lateinit var storageReference: StorageReference


    private val binding: ActivityRegistration3Binding by lazy {
        ActivityRegistration3Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar!!.hide()

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        usersRef = database.reference.child("users")
        storage = FirebaseStorage.getInstance()
        // Create a reference to the "upload" folder
        storageReference = storage.reference.child("upload")


        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        val phoneNumber = intent.getStringExtra("phone_number")
        val location = intent.getStringExtra("location")
        val role = intent.getStringExtra("role")
        val imageUri = intent.getStringExtra("image_uri")


// Assuming you have a list of education options
        val educationList = arrayOf(
            "Bachelor's Degree",
            "Master's Degree",
            "PhD",
            "Diploma",
            "High School",
            "Others"
        )
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


        val platform = arrayOf("home", "on center")
        val adapterPlatform = ArrayAdapter(this, android.R.layout.simple_list_item_1, platform)
        val autoCompleteTextViewPlatform = binding.tutorFormat
        autoCompleteTextViewPlatform.setAdapter(adapterPlatform)

        binding.finalSubmit.setOnClickListener {
            val education = binding.selectEdu.text.toString()
            val subjecto = binding.subjectOfInterest.text.toString()
            val platform = binding.tutorFormat.text.toString()
            val additionalinfo = binding.editTextAddInfo.text.toString()
            if (education.isNotBlank() && subjecto.isNotBlank() && platform.isNotBlank()) {
                if (email != null && password != null && phoneNumber != null && location != null && role != null && imageUri!=null) {
                    val uri = Uri.parse(imageUri)
                    registerUser(
                        email,
                        password,
                        phoneNumber,
                        location,
                        role,
                        education,
                        subjecto,
                        platform,
                        additionalinfo,
                        uri
                    )
                }
            } else {
                Toast.makeText(this, "please enter sufficient data", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun registerUser(
        email: String,
        password: String,
        phoneNumber: String,
        location: String,
        role: String,
        education: String,
        subjecto: String,
        platform: String,
        additionalinfo: String,
        imageUri: Uri?
    ) {
        if (password.isNotBlank() && email.isNotBlank()) {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val userId = user?.uid ?: ""
                    val userEmail = user?.email ?: ""


                    if (imageUri != null) {
                        val storageReference = storage.reference.child("profile_images").child("$userId.jpg")
                        storageReference.putFile(imageUri).addOnSuccessListener { taskSnapshot ->
                            storageReference.downloadUrl.addOnSuccessListener { uri ->
                                val imageUrl = uri.toString()

                                // Save user data to Firebase Realtime Database
                                val userData = mapOf(
                                    "email" to userEmail,
                                    "education" to education,
                                    "location" to location,
                                    "phoneNumber" to phoneNumber,
                                    "role" to role,
                                    "subjectOfInterest" to subjecto,
                                    "platform" to platform,
                                    "additionalInfo" to additionalinfo,
                                    "imageUrl" to imageUrl
                                )

                                usersRef.child(role).child(userId).setValue(userData).addOnSuccessListener {
                                    Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                                    // Redirect to next activity or perform other actions
                                }.addOnFailureListener {
                                    Toast.makeText(this, "Failed to save user data", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }.addOnFailureListener {
                            Toast.makeText(this, "Failed to upload image", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "Image URI is null", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Registration failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
        }
    }
}
