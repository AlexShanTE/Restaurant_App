package com.shante.restaurantapp.presentation.bucket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shante.restaurantapp.databinding.BucketFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BucketFragment: Fragment() {

    private lateinit var binding:BucketFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BucketFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

}