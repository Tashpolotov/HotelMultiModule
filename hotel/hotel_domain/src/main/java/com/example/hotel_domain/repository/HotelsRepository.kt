package com.example.hotels_domain.repository

import com.example.common_utils.Resource
import com.example.hotels_domain.model.Hotels
import kotlinx.coroutines.flow.Flow


interface HotelsRepository {

    fun getHotels(): Flow<Resource<Hotels>>
}