package com.example.wavesoffood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wavesoffood.databinding.ActivityLoginBinding
import com.example.wavesoffood.databinding.ActivityStartBinding

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy{
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener{
            val intent = Intent(this, ChooseLocationActivity::class.java)
            startActivity(intent)
        }

        binding.dontHaveAnAccount.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}