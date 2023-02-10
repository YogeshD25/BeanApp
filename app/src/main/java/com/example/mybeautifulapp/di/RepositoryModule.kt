package com.example.mybeautifulapp.di

import com.example.mybeautifulapp.data.repository.BeanRepository
import com.example.mybeautifulapp.data.repository.BeanRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindBeanRepository(
        beanRepositoryImpl: BeanRepositoryImpl
    ): BeanRepository

}