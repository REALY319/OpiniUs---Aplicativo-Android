package com.example.opinius.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun FeedbackScreen(navController: NavController) {
    var feedbackText by remember { mutableStateOf("") }
    var isSubmitting by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.popBackStack() }) {
            Text("Voltar")
        }

        Text("Enviar Feedback", fontSize = 20.sp, style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = feedbackText,
            onValueChange = { feedbackText = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Digite seu feedback...") },
            maxLines = 5
        )

        Button(
            onClick = {
                isSubmitting = true
            },
            enabled = feedbackText.isNotBlank(),
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Icon(imageVector = Icons.AutoMirrored.Default.Send, contentDescription = "Enviar")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Enviar")
        }
    }
}
