package com.example.feriaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.content.Intent
import androidx.compose.ui.graphics.Color

// Actividad principal de la aplicación
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilita el modo "Edge to Edge" para que la interfaz ocupe toda la pantalla
        enableEdgeToEdge()
        // Define el contenido de la actividad usando Jetpack Compose
        setContent {
            // Llama a la función MainScreen, que define la interfaz de la pantalla principal
            MainScreen(onNavigateToSecondActivity = {
                // Inicia la segunda actividad (Activity2) cuando se presione el botón
                startActivity(Intent(this, Activity2::class.java))
            })
        }
    }
}

// Función que define la pantalla principal de la aplicación
@Composable
fun MainScreen(onNavigateToSecondActivity: () -> Unit) {
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
            // Lista de negocios con sus imágenes
            BusinessItem("Negocios de la Nave 1", Color(0xFF6650a4)) // Card 1 con color Purple40
            BusinessItem("Negocios de la Nave 2", Color(0xFF6650a4)) // Card 2 con color Purple40
            BusinessItem("Negocios de la Nave 3", Color(0xFF6650a4)) // Card 3 con color Purple40
            BusinessItem("Atracciones y Conciertos", Color(0xFFD0BCFF)) // Card 4 con color Purple80

            // Botón para navegar a la segunda actividad
            Button(
                onClick = onNavigateToSecondActivity, // Acción al hacer clic en el botón
                modifier = Modifier.padding(top = 16.dp) // Agrega un padding superior de 16dp
            ) {
                // Texto del botón
                Text(
                    text = "Fechas importantes",
                    fontFamily = FontFamily.SansSerif // Usa la fuente SansSerif
                )
            }
        }
    }
}

// Función que define un componente reutilizable para mostrar un negocio con imagen
@Composable
fun BusinessItem(text: String, cardColor: Color) {
    // Card es un contenedor que muestra un elemento con sombra y bordes redondeados
    Card(
        modifier = Modifier
            .fillMaxWidth() // Ocupa todo el ancho disponible
            .height(120.dp), // Altura fija de 120dp
        colors = CardDefaults.cardColors(
            containerColor = cardColor // Color de fondo de la card
        )
    ) {
        // Row organiza los elementos en una fila horizontal
        Row(
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el espacio disponible
                .padding(8.dp), // Agrega un padding de 8dp alrededor de la fila
            verticalAlignment = Alignment.CenterVertically // Centra los elementos verticalmente
        ) {
            // Imagen del restaurante
            Image(
                painter = painterResource(id = R.drawable.logo_rest), // Carga la imagen desde recursos
                contentDescription = "Logo restaurante", // Descripción accesible para la imagen
                modifier = Modifier
                    .size(100.dp) // Tamaño fijo de 100dp
                    .padding(8.dp) // Agrega un padding de 8dp alrededor de la imagen
            )
            // Texto del negocio
            Text(
                text = text,
                modifier = Modifier.padding(8.dp), // Agrega un padding de 8dp alrededor del texto
                fontFamily = FontFamily.SansSerif // Usa la fuente SansSerif
            )
        }
    }
}

// Vista previa de la pantalla principal (MainScreen)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainScreen() {
    // Muestra una vista previa de MainScreen sin lógica de navegación
    MainScreen(onNavigateToSecondActivity = {})
}

// Vista previa de un BusinessItem
@Preview(showBackground = true)
@Composable
fun PreviewBusinessItem() {
    // Muestra una vista previa de BusinessItem con texto y color predeterminados
    BusinessItem(text = "Negocios de la Nave 1", cardColor = Color(0xFF6650a4))
}
