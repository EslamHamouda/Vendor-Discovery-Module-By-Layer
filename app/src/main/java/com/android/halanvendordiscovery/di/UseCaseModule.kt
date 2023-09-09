package com.android.halanvendordiscovery.di

import com.android.domain.details.repo.DetailsRepository
import com.android.domain.details.useCase.GetMerchantsUseCase
import com.android.domain.vendors.repo.VendorsRepository
import com.android.domain.vendors.useCase.GetVendorCategoryUseCase
import com.android.domain.vendors.useCase.GetVendorsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetMerchantsUseCase(repository: DetailsRepository): GetMerchantsUseCase {
        return GetMerchantsUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideGetVendorCategoryUseCase(repository: VendorsRepository): GetVendorCategoryUseCase {
        return GetVendorCategoryUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideGetVendorsUseCase(repository: VendorsRepository): GetVendorsUseCase {
        return GetVendorsUseCase(repository)
    }
}