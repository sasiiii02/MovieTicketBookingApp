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

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)



        val name = findViewById<EditText>(R.id.edtusername)
        val password = findViewById<EditText>(R.id.edtPassword)
        val nxtbtn :Button = findViewById(R.id.btnLogin)
        val nxtbtn2 :TextView = findViewById(R.id.btnRegister)

        nxtbtn.setOnClickListener{
            //name
            val name = name.text.toString()
            val password = password.text.toString()



            //create an implicit intent using the custom actions
            val intent = Intent(this,movieList::class.java)
            intent.putExtra("User_Name" ,name)
            intent.putExtra("Password" ,password)


            startActivity(intent)
        }
        nxtbtn2.setOnClickListener{

            //create an implicit intent using the custom actions
            val intent = Intent(this,signUp::class.java)

            startActivity(intent)
        }




    }
}