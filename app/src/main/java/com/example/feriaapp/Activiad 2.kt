package com.example.feriaapp

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

// Actividad secundaria de la aplicación
class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Define el contenido de la actividad usando Jetpack Compose
        setContent {
            // Llama a la función SecondScreen, que define la interfaz de la segunda pantalla
            SecondScreen(onBackPressed = { finish() }) // Cierra la actividad actual al presionar el botón "Volver"
        }
    }
}

// Función que define la pantalla secundaria de la aplicación
@Composable
fun SecondScreen(onBackPressed: () -> Unit) {
    // Surface es un contenedor que define el fondo de la pantalla
    Surface(
        modifier = Modifier.fillMaxSize(), // Ocupa toda la pantalla
        color = MaterialTheme.colorScheme.background // Usa el color de fondo del tema
    ) {
        // Column organiza los elementos en una columna vertical
        Column(
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el espacio disponible
                .padding(16.dp), // Agrega un padding de 16dp alrededor de la columna
            horizontalAlignment = Alignment.CenterHorizontally, // Centra los elementos horizontalmente
            verticalArrangement = Arrangement.spacedBy(16.dp) // Espacio vertical de 16dp entre elementos
        ) {
            // Lista de restaurantes
            RestaurantItem("Restaurante 1") // Muestra el primer restaurante
            RestaurantItem("Restaurante 2") // Muestra el segundo restaurante
            RestaurantItem("Restaurante 3") // Muestra el tercer restaurante

            // Botón para volver a la pantalla principal
            Button(
                onClick = onBackPressed, // Acción al hacer clic en el botón
                modifier = Modifier.padding(top = 16.dp) // Agrega un padding superior de 16dp
            ) {
                // Texto del botón
                Text(
                    text = "Volver",
                    fontFamily = FontFamily.SansSerif // Usa la fuente SansSerif
                )
            }
        }
    }
}

// Función que define un componente reutilizable para mostrar un restaurante
@Composable
fun RestaurantItem(name: String) {
    // Card es un contenedor que muestra un elemento con sombra y bordes redondeados
    Card(
        modifier = Modifier
            .fillMaxWidth() // Ocupa todo el ancho disponible
            .height(80.dp), // Altura fija de 80dp
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF6650a4) // Color de fondo de la card (Purple40)
        )
    ) {
        // Box es un contenedor que permite alinear su contenido
        Box(
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el espacio disponible
                .padding(8.dp), // Agrega un padding de 8dp alrededor del contenido
            contentAlignment = Alignment.CenterStart // Alinea el contenido al inicio (izquierda)
        ) {
            // Texto del restaurante
            Text(
                text = name,
                fontFamily = FontFamily.SansSerif, // Usa la fuente SansSerif
                color = Color.White // Texto en blanco para mejor contraste
            )
        }
    }
}

// Vista previa de la pantalla secundaria (SecondScreen)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSecondScreen() {
    // Muestra una vista previa de SecondScreen sin lógica de navegación
    SecondScreen(onBackPressed = {})
}

// Vista previa de un RestaurantItem
@Preview(showBackground = true)
@Composable
fun PreviewRestaurantItem() {
    // Muestra una vista previa de RestaurantItem con texto predeterminado
    RestaurantItem(name = "Restaurante 1")
}
