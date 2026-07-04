// Ruta: android/app/src/main/java/com/miapp/finanzas/FinanzasApplication.kt
package com.miapp.finanzas

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Raíz del grafo de Hilt. @HiltAndroidApp dispara la generación de código
 * de DI en compilación. (En Sprint 3 añadiremos Configuration.Provider
 * para WorkManager, como indica el blueprint.)
 */
@HiltAndroidApp
class FinanzasApplication : Application()