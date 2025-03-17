package com.example.opinius.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun FeedbackHistoryScreen(navController: NavController) {
    val feedbackList = remember { mutableStateListOf(
        "Ótimo ambiente de trabalho!",
        "Seria bom termos mais treinamentos.",
        "A comunicação entre equipes pode melhorar.",
        "Ótimos benefícios e horários flexíveis.",
        "Precisa de mais transparência nas decisões."
    ) }

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

        Text("Histórico de Feedbacks", fontSize = 20.sp, style = MaterialTheme.typography.titleMedium)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(feedbackList) { feedback ->
                FeedbackItem(feedback)
            }
        }
    }
}

@Composable
fun FeedbackItem(feedback: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(
            text = feedback,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
