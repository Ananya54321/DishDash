package com.example.wavesoffood

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.wavesoffood.databinding.ActivityLoginBinding
import com.example.wavesoffood.databinding.ActivitySignInBinding
import com.example.wavesoffood.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class SignInActivity : AppCompatActivity() {

    private lateinit var email : String
    private lateinit var password : String
    private lateinit var userName : String
    private lateinit var auth : FirebaseAuth
    private lateinit var database : DatabaseReference

    private val binding: ActivitySignInBinding by lazy{
        ActivitySignInBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = Firebase.auth

        database = Firebase.database.reference

        binding.createAccount.setOnClickListener{
            email = binding.emailUser.text.toString().trim()
            password = binding.passwordUser.text.toString().trim()
            userName = binding.nameUser.text.toString().trim()

            if(userName.isBlank()||password.isBlank()||email.isBlank()){
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            }
            else{
                createAccount(email, password)
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.alreadyHaveAnAccount.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{task ->
            if(task.isSuccessful){
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                saveUserData()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Account created failed", Toast.LENGTH_SHORT).show()
                Log.d("Account", "createAccount: Failure", task.exception)
            }
        }
    }

    private fun saveUserData() {
        email = binding.emailUser.text.toString().trim()
        password = binding.passwordUser.text.toString().trim()
        userName = binding.nameUser.text.toString().trim()
        val user = UserModel(userName, email, password, 0)
        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        database.child("user").child(userId).setValue(user)
    }
}