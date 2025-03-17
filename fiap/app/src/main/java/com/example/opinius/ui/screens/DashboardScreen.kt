package com.example.opinius.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.StackedLineChart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DashboardScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.popBackStack() }) {
            Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "Voltar")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Voltar")
        }

        Text("Visão Geral dos Feedbacks", fontSize = 20.sp, style = MaterialTheme.typography.titleMedium)

        DashboardCard(
            title = "Total de Feedbacks",
            value = "128",
            icon = Icons.Default.StackedLineChart
        )

        DashboardCard(
            title = "Feedbacks Críticos",
            value = "5",
            icon = Icons.Default.Warning,
            backgroundColor = MaterialTheme.colorScheme.errorContainer
        )
    }
}

@Composable
fun DashboardCard(title: String, value: String, icon: androidx.compose.ui.graphics.vector.ImageVector, backgroundColor: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.primaryContainer) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = title, modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, style = MaterialTheme.typography.labelLarge)
                Text(value, fontSize = 24.sp, style = MaterialTheme.typography.headlineSmall)
            }
        }
    }
}
