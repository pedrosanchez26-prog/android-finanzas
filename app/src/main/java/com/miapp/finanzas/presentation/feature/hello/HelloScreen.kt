// Ruta: android/app/src/main/java/com/miapp/finanzas/presentation/feature/hello/HelloScreen.kt
package com.miapp.finanzas.presentation.feature.hello

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** Pantalla temporal del scaffolding — se reemplaza por Login en ANDROID-04. */
@Composable
fun HelloScreen(onNavigateToDetail: () -> Unit) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Hola, Finanzas 👋", style = MaterialTheme.typography.headlineMedium)
            Button(onClick = onNavigateToDetail) {
                Text("Probar navegación")
            }
        }
    }
}

@Composable
fun DetailScreen(onBack: () -> Unit) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Navegación funcionando ✅", style = MaterialTheme.typography.headlineSmall)
            Button(onClick = onBack) {
                Text("Volver")
            }
        }
    }
}