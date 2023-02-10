package com.example.mybeautifulapp.data.repository

import com.example.mybeautifulapp.data.model.BeanItem
import com.example.mybeautifulapp.data.remote.RemoteApiImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BeanRepositoryImpl @Inject constructor(
    private val remoteApiImpl: RemoteApiImpl
): BeanRepository {
    override suspend fun getBeanItem(): Flow<List<BeanItem>> {
        return remoteApiImpl.getBeanDataFromApi()
    }

}