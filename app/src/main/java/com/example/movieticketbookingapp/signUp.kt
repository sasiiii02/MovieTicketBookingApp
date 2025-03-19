package com.example.movieticketbookingapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class signUp : AppCompatActivity() {

    private lateinit var nxtbtn: Button
    private lateinit var nameTobePassed: EditText
    private lateinit var emailTobePassed: EditText
    private lateinit var phoneTobePassed: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtRePassword: EditText
    private lateinit var txtLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        // Initialize views here
        nxtbtn = findViewById(R.id.btnSignUp)
        nameTobePassed = findViewById(R.id.edtUserName)
        emailTobePassed = findViewById(R.id.edtEmail)
        phoneTobePassed = findViewById(R.id.edtMobileNumber)
        edtPassword = findViewById(R.id.edtPassword)
        edtRePassword = findViewById(R.id.edtRePassword)
        txtLogin = findViewById(R.id.txtLogin)

        txtLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        nxtbtn.setOnClickListener {
            if (validateForm()) {
                registerUser()
            }
        }
    }

    private fun validateForm(): Boolean {
        var isValid = true

        // Validate user name
        if (TextUtils.isEmpty(nameTobePassed.text.toString())) {
            nameTobePassed.error = "User name is required"
            isValid = false
        }

        // Validate Email
        val email = emailTobePassed.text.toString()
        if (TextUtils.isEmpty(email)) {
            emailTobePassed.error = "Email is required"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailTobePassed.error = "Enter a valid email"
            isValid = false
        }

        // Validate Password
        val password = edtPassword.text.toString()
        val rePassword = edtRePassword.text.toString()

        if (TextUtils.isEmpty(password)) {
            edtPassword.error = "Password required"
            isValid = false
        } else if (password.length < 6) {
            edtPassword.error = "Password must be at least 6 characters"
            isValid = false
        }

        if (TextUtils.isEmpty(rePassword)) {
            edtRePassword.error = "Please confirm your password"
            isValid = false
        } else if (password != rePassword) {
            edtRePassword.error = "Passwords do not match"
            isValid = false
        }

        // Validate Mobile Number
        val phone = phoneTobePassed.text.toString()
        if (TextUtils.isEmpty(phone)) {
            phoneTobePassed.error = "Phone number is required"
            isValid = false
        } else if (!phone.matches(Regex("^[0-9]{10,15}$"))) { // Allows 10 to 15 digits
            phoneTobePassed.error = "Enter a valid mobile number"
            isValid = false
        }

        return isValid
    }

    private fun registerUser() {
        val name = nameTobePassed.text.toString()
        val email = emailTobePassed.text.toString()
        val phone = phoneTobePassed.text.toString()
        val password = edtPassword.text.toString()
        val rePassword = edtRePassword.text.toString()

        //save to singleton object

        MyCredentials.username =name
        MyCredentials.email = email
        MyCredentials.mobile =phone


        val passwordSet= MyCredentials.setPassword(password,rePassword)

        if(passwordSet){
            Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
            finish()//go back to the login screen

        }else{
            Toast.makeText(this, "Password does not  match!", Toast.LENGTH_SHORT).show()

        }
    }
}
