package com.example.hotel_presentation

import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.hotel_presentation.databinding.FragmentHotelsBinding
import com.example.hotels2.presentation.base.BaseFragment
import com.example.hotels2.presentation.ui.fragments.hotel.adapter.HotelsAdapter
import com.example.hotel_presentation.viewmodel.HotelsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HotelsFragment : BaseFragment(R.layout.fragment_hotels) {

    private val binding by viewBinding(FragmentHotelsBinding::bind)
    private val hotelsViewModel by lazy {
        ViewModelProvider(this)[HotelsViewModel::class.java]
    }
    private val adapter by lazy { HotelsAdapter(requireContext()) }
    private var selectedHotelName: String? = null


    override fun initialize() {
        binding.rvHotels.adapter = adapter

    }

    override fun setupRequests() {
        hotelsViewModel.getHotels()
    }

    override fun setupSubscribers() {
    }

    override fun setupListeners() {
        binding.btnToChooseNumber.setOnClickListener {
            selectedHotelName?.let { name ->
                val req = NavDeepLinkRequest.Builder
                    .fromUri("android-app://androidx.navigation.app/roomFragment".toUri())
                    .build()
                findNavController().navigate(req)
            }
        }
    }

    override fun initSubscribers() {
        hotelsViewModel.getHotelStar.collectUIState(
            state = {
                binding.progressBar.isVisible = true
                binding.rvHotels.isVisible = false
                binding.flBtn.isVisible = false
            },
            onSuccess = {
                adapter.submitList(listOf(it))
                selectedHotelName = it.name
                binding.progressBar.isVisible = false
                binding.rvHotels.isVisible = true
                binding.flBtn.isVisible = true
            }
        )
    }

    companion object {
        const val ARGS_HOTEL_NAME = "hotel_name"
    }
}