package com.umrhsn.shoestore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.umrhsn.shoestore.R
import com.umrhsn.shoestore.databinding.FragmentLoginBinding
import com.umrhsn.shoestore.databinding.FragmentShoeDetailBinding
import com.umrhsn.shoestore.viewmodels.ShoeDetailViewModel
import com.umrhsn.shoestore.viewmodels.ShoeListViewModel

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var shoeDetailViewModel: ShoeDetailViewModel
    private lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        shoeDetailViewModel = ViewModelProvider(this)[ShoeDetailViewModel::class.java]
        binding.viewModel = shoeDetailViewModel

        binding.lifecycleOwner = this

        binding.btnSave.setOnClickListener {
            val shoe = shoeDetailViewModel.saveShoeData()
            shoeListViewModel.addShoe(shoe)
            navigateToShoeListFragment()
        }

        binding.btnSave.setOnClickListener {
            navigateToShoeListFragment()
        }

        return binding.root
    }

    private fun navigateToShoeListFragment() {
        findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }
}