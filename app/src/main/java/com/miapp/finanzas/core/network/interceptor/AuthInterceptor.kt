// Ruta: android/app/src/main/java/com/miapp/finanzas/core/network/interceptor/AuthInterceptor.kt
package com.miapp.finanzas.core.network.interceptor

import com.miapp.finanzas.core.security.TokenManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/** Añade el header Authorization con el access token (si existe) a cada request. */
class AuthInterceptor @Inject constructor(
    private val tokenManager: TokenManager,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = tokenManager.getAccessToken()
        val request = chain.request().newBuilder().apply {
            token?.let { addHeader("Authorization", "Bearer $it") }
        }.build()
        return chain.proceed(request)
    }
}