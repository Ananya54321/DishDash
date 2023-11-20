package com.example.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.example.wavesoffood.adapterFood.BuyAgainAdapter
import com.example.wavesoffood.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView5.setImageResource(R.drawable.menu2) // Initialize here

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
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

    companion object { }
}
