// Ruta: android/app/src/main/java/com/miapp/finanzas/presentation/MainActivity.kt
package com.miapp.finanzas.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.miapp.finanzas.presentation.navigation.AppNavHost
import com.miapp.finanzas.presentation.theme.FinanzasTheme
import dagger.hilt.android.AndroidEntryPoint

/** @AndroidEntryPoint permite que Hilt inyecte en esta Activity y sus ViewModels. */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinanzasTheme {
                AppNavHost()
            }
        }
    }
}