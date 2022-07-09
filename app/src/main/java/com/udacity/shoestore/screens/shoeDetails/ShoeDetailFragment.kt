package com.udacity.shoestore.screens.shoeDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeListDetailsViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeListDetailsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        binding.cancelButton.setOnClickListener {
            it.findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.submitButton.setOnClickListener {
            var shoeName = binding.textShoeName.text.toString()
            var shoeSize: Double
            var shoeCompany: String = binding.textShoeCompany.text.toString()
            var shoeDescription: String = binding.textShoeDescription.text.toString()
            try {
                shoeSize = binding.textShoeSize.text.toString().toDouble()
            } catch (ex: Exception) {
                shoeSize = -1.0
            }
            viewModel.addShoe(Shoe(shoeName, shoeSize, shoeCompany, shoeDescription))
            it.findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        return binding.root
    }


}