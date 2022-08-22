package com.umrhsn.shoestore.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.umrhsn.shoestore.R
import com.umrhsn.shoestore.databinding.FragmentShoeDetailBinding
import com.umrhsn.shoestore.viewmodels.ShoeDetailViewModel
import com.umrhsn.shoestore.viewmodels.ShoeListViewModel
import timber.log.Timber

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var shoeDetailViewModel: ShoeDetailViewModel
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

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
            Timber.i("shoe = $shoe")
            // FIXME: no shoe data
            //  shoe = Shoe(name=, size=0, company=, description=)
            shoeListViewModel.addShoe(shoe)
            navigateToShoeListFragment()
        }

        binding.btnCancel.setOnClickListener {
            navigateToShoeListFragment()
        }

        return binding.root
    }

    private fun navigateToShoeListFragment() {
        findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }
}