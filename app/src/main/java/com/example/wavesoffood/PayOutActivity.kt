package com.example.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wavesoffood.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {
    lateinit var binding : ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_out)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        binding.placeMyOrder.setOnClickListener{
//            val bottomSheetDialog = CongratsBottomSheetFragment()
//            bottomSheetDialog.show(supportFragmentManager, "Test")

        }
    }
}