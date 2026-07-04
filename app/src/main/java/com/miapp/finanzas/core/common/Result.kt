// Ruta: android/app/src/main/java/com/miapp/finanzas/core/common/Result.kt
package com.miapp.finanzas.core.common

/**
 * Wrapper del estado de una operación asíncrona (blueprint core/common).
 * Nombrado igual que kotlin.Result a propósito del blueprint: al usarlo,
 * importa SIEMPRE com.miapp.finanzas.core.common.Result.
 */
sealed interface Result<out T> {
    data object Loading : Result<Nothing>
    data class Success<T>(val data: T) : Result<T>
    data class Error(val throwable: Throwable? = null, val message: String? = null) : Result<Nothing>
}