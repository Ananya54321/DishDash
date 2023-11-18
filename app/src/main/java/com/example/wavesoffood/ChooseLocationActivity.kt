package com.example.wavesoffood

import android.R
import android.health.connect.datatypes.ExerciseRoute.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.wavesoffood.databinding.ActivityChooseLocationBinding
import com.example.wavesoffood.databinding.ActivityLoginBinding

class ChooseLocationActivity : AppCompatActivity() {
    private val binding: ActivityChooseLocationBinding by lazy{
       ActivityChooseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val locationlist : Array<String> = arrayOf("Jaipur", "Telangana", "Odisha", "Kerala")
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, locationlist)
        val autoCompleteTextView : AutoCompleteTextView = binding.listOfLocations

        autoCompleteTextView.setAdapter(adapter)
    }
}