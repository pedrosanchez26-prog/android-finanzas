// Ruta: android/app/src/main/java/com/miapp/finanzas/core/security/TokenManager.kt
package com.miapp.finanzas.core.security

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Guarda/lee/borra los tokens CIFRADOS en disco.
 * - MasterKey: clave AES-256 que vive en el Android Keystore (hardware si el
 *   dispositivo lo soporta) — nunca sale de ahí.
 * - EncryptedSharedPreferences cifra claves y valores con esa MasterKey.
 * Los métodos son síncronos a propósito: los consumirán el AuthInterceptor y
 * el TokenAuthenticator, que operan en los hilos de OkHttp (nunca en Main).
 */
@Singleton
class TokenManager @Inject constructor(
    @ApplicationContext context: Context,
) {

    private val prefs: SharedPreferences by lazy {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        EncryptedSharedPreferences.create(
            context,
            PREFS_FILE_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
        )
    }

    fun saveTokens(accessToken: String, refreshToken: String) {
        prefs.edit()
            .putString(KEY_ACCESS_TOKEN, accessToken)
            .putString(KEY_REFRESH_TOKEN, refreshToken)
            .apply()
    }

    fun getAccessToken(): String? = prefs.getString(KEY_ACCESS_TOKEN, null)

    fun getRefreshToken(): String? = prefs.getString(KEY_REFRESH_TOKEN, null)

    /** Logout local: borra ambos tokens. */
    fun clear() {
        prefs.edit()
            .remove(KEY_ACCESS_TOKEN)
            .remove(KEY_REFRESH_TOKEN)
            .apply()
    }

    fun hasSession(): Boolean = getAccessToken() != null

    private companion object {
        const val PREFS_FILE_NAME = "finanzas_secure_prefs"
        const val KEY_ACCESS_TOKEN = "access_token"
        const val KEY_REFRESH_TOKEN = "refresh_token"
    }
}