package com.android.halanvendordiscovery.di

import com.android.data.details.service.DetailsService
import com.android.data.vendors.service.VendorsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun detailsService(retrofit: Retrofit): DetailsService =
        retrofit.create(DetailsService::class.java)
    @Provides
    @Singleton
    fun vendorsService(retrofit: Retrofit): VendorsService =
        retrofit.create(VendorsService::class.java)
}