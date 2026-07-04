// Ruta: android/app/src/main/java/com/miapp/finanzas/core/network/ApiResult.kt
package com.miapp.finanzas.core.network

import java.io.IOException

/**
 * Resultado tipado de una llamada HTTP (blueprint core/network).
 * Distingue el fallo HTTP (el servidor respondió con error) del fallo de RED
 * (no hubo respuesta) — distinción vital en offline-first: un error de red
 * significa "reintentar luego", un 4xx significa "no reintentes, corrige".
 */
sealed interface ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>
    data class HttpError(val code: Int, val message: String?) : ApiResult<Nothing>
    data class NetworkError(val exception: IOException) : ApiResult<Nothing>
}

/** Ejecuta una llamada de API capturando errores de red y HTTP de forma segura. */
suspend fun <T> safeApiCall(block: suspend () -> T): ApiResult<T> = try {
    ApiResult.Success(block())
} catch (e: retrofit2.HttpException) {
    ApiResult.HttpError(code = e.code(), message = e.message())
} catch (e: IOException) {
    ApiResult.NetworkError(e)
}