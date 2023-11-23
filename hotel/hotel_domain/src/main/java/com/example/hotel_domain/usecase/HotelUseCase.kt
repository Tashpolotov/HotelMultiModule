package com.example.hotels_domain.usecase

import com.example.hotels_domain.repository.HotelsRepository
import javax.inject.Inject

class HotelUseCase @Inject constructor(private val repository: HotelsRepository) {

        fun getHotels() = repository.getHotels()
}