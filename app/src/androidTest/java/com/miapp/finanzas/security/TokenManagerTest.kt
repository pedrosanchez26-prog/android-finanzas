// Ruta: android/app/src/androidTest/java/com/miapp/finanzas/core/security/TokenManagerTest.kt
package com.miapp.finanzas.security

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.miapp.finanzas.core.security.TokenManager
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TokenManagerTest {

    private lateinit var tokenManager: TokenManager

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        tokenManager = TokenManager(context)
        tokenManager.clear()   // estado limpio por test (la lección de BACKEND-01 aplica aquí también)
    }

    @Test
    fun guardaYLeeTokens() {
        tokenManager.saveTokens(accessToken = "access-123", refreshToken = "refresh-456")

        assertEquals("access-123", tokenManager.getAccessToken())
        assertEquals("refresh-456", tokenManager.getRefreshToken())
        assertTrue(tokenManager.hasSession())
    }

    @Test
    fun clearBorraAmbosTokens() {
        tokenManager.saveTokens(accessToken = "access-123", refreshToken = "refresh-456")

        tokenManager.clear()

        assertNull(tokenManager.getAccessToken())
        assertNull(tokenManager.getRefreshToken())
        assertFalse(tokenManager.hasSession())
    }

    @Test
    fun sinTokensNoHaySesion() {
        assertNull(tokenManager.getAccessToken())
        assertFalse(tokenManager.hasSession())
    }
}