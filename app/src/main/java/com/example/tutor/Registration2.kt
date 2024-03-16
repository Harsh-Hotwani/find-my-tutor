package com.example.tutor

import android.R
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tutor.databinding.ActivityRegistration1Binding
import com.example.tutor.databinding.ActivityRegistration2Binding


class Registration2 : AppCompatActivity() {
    private val binding:ActivityRegistration2Binding by lazy {
        ActivityRegistration2Binding.inflate(layoutInflater)
    }

    private var PICK_IMAGE_REQUEST=1
    private var imageuri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar!!.hide()

        val locationList = arrayOf("indore","bhopal","gwalior","jabalpur")
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView = binding.listoflocation
        autoCompleteTextView.setAdapter(adapter)

        val roleList = arrayOf("student","teacher")
        val adapterRole = ArrayAdapter(this, R.layout.simple_list_item_1,roleList)
        val autoCompleteTextViewRole = binding.selectRole
        autoCompleteTextViewRole.setAdapter(adapterRole)

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        val phoneNumber = intent.getStringExtra("phone_number")

       binding.next2.setOnClickListener {

           val location = binding.listoflocation.text.toString()
           val role = binding.selectRole.text.toString()
//
//            // Combine the previous data with additional data
//            val combinedData = "$email, $password, $phoneNumber, $location"
//           Toast.makeText(this, combinedData, Toast.LENGTH_SHORT).show()
//            // Start the next activity or save the data to database
//            // For example:
           if (location.isNotBlank() && role.isNotBlank()) {
               val intent = Intent(this, Registration3::class.java).apply {
                   putExtra("email", email)
                   putExtra("password", password)
                   putExtra("phone_number", phoneNumber)
                   putExtra("location", location)
                   putExtra("role", role)
                   putExtra("image_uri", imageuri?.toString())
               }
               startActivity(intent)
           }
           else
           {
               Toast.makeText(this, "please enter sufficient details", Toast.LENGTH_SHORT).show()
           }
       }

        binding.cardView.setOnClickListener{
            val intent = Intent()
            intent.type="image/*"
            intent.action=Intent.ACTION_GET_CONTENT
            startActivityForResult(
                Intent.createChooser(intent , "select a image"),
                PICK_IMAGE_REQUEST
            )
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data!=null && data.data!=null) {
            imageuri = data.data
            Glide.with(this)
                .load(imageuri)
                .apply(RequestOptions.circleCropTransform())
                .into(binding.registerImage)
        }
    }
}