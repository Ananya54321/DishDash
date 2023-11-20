package com.example.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wavesoffood.databinding.ActivityPayOutBinding
import com.example.wavesoffood.databinding.FragmentHomeBinding

class PayOutActivity : AppCompatActivity() {
    lateinit var binding : ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.placeMyOrder.setOnClickListener{
            val bottomSheetDialog = CongratsBottomSheetFragment()
            bottomSheetDialog.show(supportFragmentManager, "Test")
        }

//        binding = FragmentHomeBinding.inflate(inflater, container, false)
//        binding.ViewMenu.setOnClickListener{
//            val bottomSheetDialog = MenuBottomSheetFragment()
//            bottomSheetDialog.show(parentFragmentManager, "Test")
//        }
//        return binding.root
    }
}