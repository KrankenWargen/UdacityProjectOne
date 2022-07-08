package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeListDetailsViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding


// TODO: Rename parameter arguments, choose names that match

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeListDetailsViewModel by activityViewModels()

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        val tl = binding.simpleTableLayout
/* Create a new row to be added. */
        viewModel.shoes.observe(viewLifecycleOwner, { shoes ->
            for (shoe in shoes) {
                val tr = TableRow(activity)
                tr.layoutParams = TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT
                )
                val tvName = TextView(activity)
                tvName.text = shoe.name
                tvName.setPadding(50)

                val tvCompany = TextView(activity)
                tvCompany.text = shoe.company
                tvCompany.setPadding(50)

                val tvSize = TextView(activity)
                tvSize.text = shoe.size.toString()
                tvSize.setPadding(50)

                val tvDesc = TextView(activity)
                tvDesc.text = shoe.description
                tvDesc.setPadding(50)

                tr.addView(tvName)
                tr.addView(tvCompany)
                tr.addView(tvSize)
                tr.addView(tvDesc)
                tl.addView(tr)
            }

        })




        binding.addShoe.setOnClickListener {
            it.findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        return binding.root
    }

}