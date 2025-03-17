package com.example.opinius.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(
    userName: String,
    userEmail: String,
    onNameChanged: (String) -> Unit,
    onSaveClick: () -> Unit
) {
    var editedName by remember { mutableStateOf(userName) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Meu Perfil",
            fontSize = 22.sp,
            style = MaterialTheme.typography.titleLarge
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Nome", style = MaterialTheme.typography.labelLarge)
                OutlinedTextField(
                    value = editedName,
                    onValueChange = { editedName = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Text("Email", style = MaterialTheme.typography.labelLarge)
                OutlinedTextField(
                    value = userEmail,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
            }
        }

        Button(
            onClick = {
                onNameChanged(editedName)
                onSaveClick()
            },
            modifier = Modifier.fillMaxWidth(0.6f),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Salvar Alterações")
        }
    }
}
