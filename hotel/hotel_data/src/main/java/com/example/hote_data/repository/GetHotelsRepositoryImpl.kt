package com.example.data.repository

import com.example.data.base.BaseRepository
import com.example.data.mappers.toHotels
import com.example.data.remote.service.ApiService
import com.example.hotels_domain.repository.HotelsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHotelsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : BaseRepository(), HotelsRepository {
    override fun getHotels() = doRequest {
        apiService.getHotels().toHotels()
    }


}