// Ruta: android/app/src/main/java/com/miapp/finanzas/presentation/navigation/AppNavHost.kt
package com.miapp.finanzas.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miapp.finanzas.presentation.feature.hello.DetailScreen
import com.miapp.finanzas.presentation.feature.hello.HelloScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HelloRoute) {
        composable<HelloRoute> {
            HelloScreen(onNavigateToDetail = { navController.navigate(DetailRoute) })
        }
        composable<DetailRoute> {
            DetailScreen(onBack = { navController.popBackStack() })
        }
    }
}