package com.example.mybeautifulapp.data.remote

import com.example.mybeautifulapp.data.model.BeanItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface RemoteApi {

    @GET("products.json?brand=maybelline")
    suspend fun fetchAllBeanItem(): Flow<List<BeanItem>>
}