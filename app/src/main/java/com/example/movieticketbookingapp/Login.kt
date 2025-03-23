package com.example.movieticketbookingapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Initialize UI elements inside onCreate
        name = findViewById(R.id.edtusername)
        password = findViewById(R.id.edtPassword)
        val nxtbtn: Button = findViewById(R.id.btnLogin)
        val nxtbtn2: TextView = findViewById(R.id.btnRegister)
        nxtbtn.setOnClickListener {
            val intent = Intent(this, movieList::class.java)
            startActivity(intent)
        }


        // Set click listener for login button
        //nxtbtn.setOnClickListener {
        //    if (validateForm()) {
        //        attemptLogin()
        //    }
        //}

        // Set click listener for register button
        nxtbtn2.setOnClickListener {
            val intent = Intent(this, signUp::class.java)
            startActivity(intent)
        }
    }

    private fun validateForm(): Boolean {
        var isValid = true

        // Validate username
        if (TextUtils.isEmpty(name.text.toString())) {
            name.error = "User name is required"
            isValid = false
        }

        // Validate password
        if (TextUtils.isEmpty(password.text.toString())) {
            password.error = "Password required"
            isValid = false
        }

        return isValid
    }

    private fun attemptLogin() {
        val usernameInput = name.text.toString()
        val passwordInput = password.text.toString()

        // Check if username is empty before validating credentials
        if (usernameInput.isEmpty()) {
            Toast.makeText(this, "Username cannot be empty!", Toast.LENGTH_SHORT).show()
            return
        }

        // Validate credentials
        if (usernameInput == MyCredentials.username) {
            if (MyCredentials.getPassword(passwordInput)) {
                val intent = Intent(this, movieList::class.java)
                startActivity(intent)

                // Clear fields after login
                name.text.clear()
                password.text.clear()
            } else {
                Toast.makeText(this, "Invalid password!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Invalid username!", Toast.LENGTH_SHORT).show()
        }
    }
}
