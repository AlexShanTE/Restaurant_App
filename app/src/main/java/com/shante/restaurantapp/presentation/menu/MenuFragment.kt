package com.shante.restaurantapp.presentation.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.shante.restaurantapp.R
import com.shante.restaurantapp.databinding.MenuFragmentBinding
import com.shante.restaurantapp.utils.MarginItemDecoration
import com.shante.restaurantapp.utils.TestData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private lateinit var binding: MenuFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MenuFragmentBinding.inflate(inflater, container, false)

        //Cities
        val citiesAdapter =
            ArrayAdapter(requireContext(), R.layout.cities_spinner_menu_item, TestData.cities)
        binding.collapsingToolbar.citiesMenu.adapter = citiesAdapter

        //MenuCategory
        val menuCategoryAdapter = MenuCategoryAdapter() { menuCategory ->

        }
        binding.collapsingToolbar.menuCategory.adapter = menuCategoryAdapter
        menuCategoryAdapter.submitList(TestData.menu_category_list)

        //Banner
        val advertisingBannerAdapter = AdvertisingBannerAdapter() { advertisingBannerItem ->

        }
        binding.collapsingToolbar.advertisingBannerRecyclerview.adapter = advertisingBannerAdapter
        binding.collapsingToolbar.advertisingBannerRecyclerview.addItemDecoration(
            MarginItemDecoration(spaceLeft = 20, spaceRight = 20)
        )
        advertisingBannerAdapter.submitList(TestData.banners)

        return binding.root
    }

}