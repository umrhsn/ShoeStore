package com.umrhsn.shoestore.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.umrhsn.shoestore.R
import com.umrhsn.shoestore.databinding.FragmentShoeListBinding
import com.umrhsn.shoestore.databinding.ShoeItemBinding
import com.umrhsn.shoestore.models.Shoe
import com.umrhsn.shoestore.viewmodels.MainViewModel

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.fabShoeDetail.setOnClickListener {
            navigateToShoeDetailFragment()
        }

        viewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
            shoeList?.forEach { shoe ->
                addShoeItem(shoe)
            }
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun addShoeItem(shoe: Shoe) {
        val shoeItemBinding: ShoeItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.shoe_item, null, false)

        shoeItemBinding.shoeName.text = shoe.name
        shoeItemBinding.shoeSize.text = shoe.size.toString()
        shoeItemBinding.shoeCompany.text = shoe.company
        shoeItemBinding.shoeDescription.text = shoe.description

        binding.shoeItemLayout.addView(shoeItemBinding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        return true
    }

    private fun navigateToShoeDetailFragment() {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
    }
}