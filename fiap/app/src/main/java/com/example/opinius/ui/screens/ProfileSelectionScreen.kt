package com.example.opinius.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileSelectionScreen(
    onProfileSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Selecione seu perfil",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        ProfileOption("Empresa", onProfileSelected)
        Spacer(modifier = Modifier.height(16.dp))

        ProfileOption("Cliente", onProfileSelected)
        Spacer(modifier = Modifier.height(16.dp))

        ProfileOption("Colaborador", onProfileSelected)
    }
}

@Composable
fun ProfileOption(profile: String, onProfileSelected: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onProfileSelected(profile) },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = profile, fontSize = 18.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileSelectionScreenPreview() {
    ProfileSelectionScreen(onProfileSelected = {})
}
