// Ruta: android/app/src/main/java/com/miapp/finanzas/core/common/DispatcherProvider.kt
package com.miapp.finanzas.core.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Abstrae los Dispatchers para poder inyectar un TestDispatcher en tests
 * (usar Dispatchers.IO hardcodeado hace el código intesteable).
 */
interface DispatcherProvider {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
}

class DefaultDispatcherProvider @Inject constructor() : DispatcherProvider {
    override val io: CoroutineDispatcher get() = Dispatchers.IO
    override val main: CoroutineDispatcher get() = Dispatchers.Main
    override val default: CoroutineDispatcher get() = Dispatchers.Default
}