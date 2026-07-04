// Ruta: android/app/src/main/java/com/miapp/finanzas/core/di/DispatcherModule.kt
package com.miapp.finanzas.core.di

import com.miapp.finanzas.core.common.DefaultDispatcherProvider
import com.miapp.finanzas.core.common.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {

    /** Cuando alguien pida DispatcherProvider, Hilt entrega DefaultDispatcherProvider. */
    @Binds
    @Singleton
    abstract fun bindDispatcherProvider(impl: DefaultDispatcherProvider): DispatcherProvider
}