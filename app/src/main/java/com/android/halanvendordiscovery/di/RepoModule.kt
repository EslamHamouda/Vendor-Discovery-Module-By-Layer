package com.android.halanvendordiscovery.di

import com.android.data.details.repo.DetailsRepositoryImpl
import com.android.data.details.service.DetailsService
import com.android.data.vendors.repo.VendorsRepositoryImpl
import com.android.data.vendors.service.VendorsService
import com.android.domain.details.repo.DetailsRepository
import com.android.domain.vendors.repo.VendorsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun provideDetailsRepository(service: DetailsService): DetailsRepository {
        return DetailsRepositoryImpl(service)
    }
    @Provides
    @Singleton
    fun provideVendorRepository(service: VendorsService): VendorsRepository {
        return VendorsRepositoryImpl(service)
    }
}