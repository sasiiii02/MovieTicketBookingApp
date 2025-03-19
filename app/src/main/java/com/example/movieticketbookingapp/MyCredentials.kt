package com.example.movieticketbookingapp

object MyCredentials {
    var username=""
    var email =""
    var mobile=""
    private var password =""
    fun setPassword(password:String,rePassword:String):Boolean{
        return if(password==rePassword){
            this.password=password
            true
        }else{
            false
        }
    }
    fun getPassword(pass:String):Boolean{
        return this.password==pass
    }
}