package com.maestrocorona.appferia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondScreen(onBackPressed = { finish() })
        }
    }
}

@Composable
fun SecondScreen(onBackPressed: () -> Unit) {
    // Pantalla secundaria con lista de restaurantes
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Lista de restaurantes
            RestaurantItem("Restaurante 1")
            RestaurantItem("Restaurante 2")
            RestaurantItem("Restaurante 3")

            // Botón para volver
            Button(
                onClick = onBackPressed,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = "Volver",
                    fontFamily = FontFamily.SansSerif // Cambio de tipo de letra
                )
            }
        }
    }
}

@Composable
fun RestaurantItem(name: String) {
    // Componente reutilizable para mostrar un restaurante
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF6650a4) // Purple40
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = name,
                fontFamily = FontFamily.SansSerif, // Cambio de tipo de letra
                color = Color.White // Texto en blanco para mejor contraste
            )
        }
    }
}

// Vista previa de SecondScreen
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSecondScreen() {
    SecondScreen(onBackPressed = {})
}

// Vista previa de RestaurantItem
@Preview(showBackground = true)
@Composable
fun PreviewRestaurantItem() {
    RestaurantItem(name = "Restaurante 1")
}