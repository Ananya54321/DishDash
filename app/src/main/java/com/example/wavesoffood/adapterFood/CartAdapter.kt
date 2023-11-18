package com.example.wavesoffood.adapterFood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.CartItemBinding

class CartAdapter(private val cartItems : MutableList<String>, private val cartPrices: MutableList<String>, private var cartImages :MutableList<Int>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(cartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size

    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cartFoodName.text = cartItems[position]
                cartItemPrice.text = cartPrices[position]
                cartItemImage.setImageResource(cartImages[position])
                cartItemQuantity.text = quantity.toString()

                minusButton.setOnClickListener{
                    decreaseQuantity(position)
                }
                plusButton.setOnClickListener{
                    increaseQuantity(position)
                }
                deleteButton.setOnClickListener{
                    val itemPosition = adapterPosition
                    if(itemPosition != RecyclerView.NO_POSITION){
                        deleteQuantity(itemPosition)
                    }
                }
            }
        }
        private fun decreaseQuantity(position: Int)
        {
            if(itemQuantities[position]>1){
                itemQuantities[position]--
                binding.cartItemQuantity.text = itemQuantities[position].toString()
            }
        }
        private fun increaseQuantity(position: Int)
        {
            if(itemQuantities[position]<10){
                itemQuantities[position]++
                binding.cartItemQuantity.text = itemQuantities[position].toString()
            }
        }
        private fun deleteQuantity(position: Int)
        {
            if(itemQuantities[position]>1){
                cartItems.removeAt(position)
                cartImages.removeAt(position)
                cartPrices.removeAt(position)
                notifyItemRemoved(position)
                notifyItemChanged(position, cartItems.size)
            }
        }

    }

}