package com.example.mybeautifulapp.data.remote

import com.example.mybeautifulapp.data.model.BeanItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteApiImpl @Inject constructor(
    private val remoteApi: RemoteApi
) {

    suspend fun getBeanDataFromApi(): Flow<List<BeanItem>> {
        return remoteApi.fetchAllBeanItem()
    }
}