package com.umrhsn.shoestore.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.umrhsn.shoestore.R
import com.umrhsn.shoestore.databinding.FragmentShoeListBinding
import com.umrhsn.shoestore.databinding.ShoeItemBinding
import com.umrhsn.shoestore.models.Shoe
import com.umrhsn.shoestore.viewmodels.ShoeListViewModel

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        shoeListViewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]
        binding.viewModel = shoeListViewModel
        binding.lifecycleOwner = this

        binding.fabShoeDetail.setOnClickListener {
            navigateToShoeDetailFragment()
        }

        shoeListViewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
            shoeList.forEach { shoe ->
                addShoeItem(container, shoe)
            }
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun addShoeItem(
        container: ViewGroup?,
        shoe: Shoe,
    ) {
        val shoeItemBinding: ShoeItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.shoe_item, container, false)
        shoeItemBinding.shoe = shoe
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