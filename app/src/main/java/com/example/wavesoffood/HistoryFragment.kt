package com.example.wavesoffood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.createBitmap
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.adapterFood.BuyAgainAdapter
import com.example.wavesoffood.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.imageView5.setImageResource(R.drawable.menu2)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView(){
        val buyAgainFoodName = arrayListOf("Momos", "Chop Suey", "Burger")
        val buyAgainFoodPrice = arrayListOf("$10", "$16", "$8")
        val buyAgainFoodImage = arrayListOf(
            R.drawable.menu1,
            R.drawable.menu5,
            R.drawable.menu4
        )
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImage)
        binding.BuyAgainRecyclerView.adapter = buyAgainAdapter
        binding.BuyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    companion object {
    }
}