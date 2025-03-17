package com.example.opinius.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import com.example.opinius.R


@Composable
fun LoginScreen(
    onLoginSuccess: (String, String) -> Unit,
    onNavigateToRegister: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo da Aplicação",
            modifier = Modifier
                .height(120.dp)
                .padding(bottom = 24.dp),
            contentScale = ContentScale.Fit
        )

        Text("Login", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation()
        )
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Nome") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            onLoginSuccess(userName.ifBlank { "Usuário" }, email)
        }) {
            Text("Entrar")
        }

        TextButton(onClick = onNavigateToRegister) {
            Text("Criar Conta")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginSuccess = { name, email ->
            println("Nome: $name, Email: $email")
        },
        onNavigateToRegister = {}
    )
}


