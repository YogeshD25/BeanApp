package com.example.mybeautifulapp.data.repository

import com.example.mybeautifulapp.data.model.BeanItem
import kotlinx.coroutines.flow.Flow

interface BeanRepository {

    suspend fun getBeanItem(): Flow<List<BeanItem>>
}