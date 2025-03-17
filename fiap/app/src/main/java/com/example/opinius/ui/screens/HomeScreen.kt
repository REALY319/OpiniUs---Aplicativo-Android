package com.example.opinius.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController, userName: String, userEmail: String) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Olá, $userName 👋",
                    style = MaterialTheme.typography.headlineSmall
                )
                IconButton(onClick = {
                    navController.navigate("profile/$userName/$userEmail")
                }) {
                    Icon(Icons.Default.Person, contentDescription = "Perfil")
                }
            }

            Text(
                text = "O que você deseja fazer?",
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleMedium
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                HomeCard(
                    title = "Dashboard",
                    icon = Icons.Default.BarChart,
                    onClick = { navController.navigate("dashboard") }
                )

                HomeCard(
                    title = "Enviar Feedback",
                    icon = Icons.Default.Feedback,
                    onClick = { navController.navigate("feedbackForm") }
                )
            }

            HomeCard(
                title = "Histórico",
                icon = Icons.Default.History,
                onClick = { navController.navigate("feedbackHistory") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
        }
    }
}


@Composable
fun HomeCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
        .width(140.dp)
        .height(140.dp)
) {
    Card(
        modifier = modifier
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = title, fontSize = 16.sp)
        }
    }
}
