// Ruta: android/app/src/main/java/com/miapp/finanzas/presentation/navigation/Routes.kt
package com.miapp.finanzas.presentation.navigation

import kotlinx.serialization.Serializable

/** Rutas type-safe: el compilador detecta errores que con strings serían crashes en runtime. */
@Serializable
data object HelloRoute

@Serializable
data object DetailRoute