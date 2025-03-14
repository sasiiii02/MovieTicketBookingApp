package com.example.movieticketbookingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class signUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        val nxtbtn : Button = findViewById(R.id.btnSignUp)
        val nameTobePassed = findViewById<EditText>(R.id.edtUserName)
        val emailTobePassed = findViewById<EditText>(R.id.edtEmail)
        val phoneTobePassed = findViewById<EditText>(R.id.edtMobileNumber)
        val txtLogin= findViewById<TextView>(R.id.txtLogin)
        txtLogin.setOnClickListener{
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }

        nxtbtn.setOnClickListener{
            //name
            val name = nameTobePassed.text.toString()
            val email = emailTobePassed.text.toString()
            val phone = phoneTobePassed.text.toString()

            //create an implicit intent using the custom actions
            val intent = Intent(this,UserProfile::class.java)
            intent.putExtra("User_Name" ,name)
            intent.putExtra("Email" ,email)
            intent.putExtra("Phone" ,phone)

            startActivity(intent)
        }



    }
}