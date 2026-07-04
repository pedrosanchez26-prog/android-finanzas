// Ruta: android/app/src/main/java/com/miapp/finanzas/core/network/interceptor/TokenAuthenticator.kt
package com.miapp.finanzas.core.network.interceptor

import com.miapp.finanzas.core.security.TokenManager
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

/**
 * OkHttp lo invoca automáticamente SOLO ante un 401. Su trabajo (ANDROID-03):
 * refrescar el token con AuthApi y reintentar el request original.
 *
 * CABLEADO en ANDROID-02, lógica pendiente: devolver null significa
 * "no puedo recuperarme" y OkHttp deja propagar el 401.
 */
class TokenAuthenticator @Inject constructor(
    private val tokenManager: TokenManager,
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        // TODO(ANDROID-03): refresh con Mutex (evitar thundering herd) + reintento.
        // Por ahora: si hay 401, no hay recuperación posible todavía.
        return null
    }
}