package com.example.data.remote.service

import com.example.data.model.HotelsModel
import retrofit2.http.GET

    interface ApiService {
        @GET("d144777c-a67f-4e35-867a-cacc3b827473")
        suspend fun getHotels(): HotelsModel

}