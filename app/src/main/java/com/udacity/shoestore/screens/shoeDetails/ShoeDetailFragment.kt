package com.udacity.shoestore.screens.shoeDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeListDetailsViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeListDetailsViewModel by activityViewModels()
    private val shoe = Shoe()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        binding.shoe = shoe;
        binding.lifecycleOwner = this
        binding.cancelButton.setOnClickListener {
            it.findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.submitButton.setOnClickListener {
            viewModel.addShoe(binding.shoe ?: return@setOnClickListener)
            it.findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        return binding.root
    }


}