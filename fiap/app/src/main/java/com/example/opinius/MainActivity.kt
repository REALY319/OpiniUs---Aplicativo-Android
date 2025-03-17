package com.example.opinius

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import com.example.opinius.ui.screens.*
import androidx.navigation.navArgument
import com.example.opinius.ui.theme.FiapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FiapTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginSuccess = { userName, userEmail ->
                    val encodedName = URLEncoder.encode(userName, StandardCharsets.UTF_8.toString())
                    val encodedEmail =
                        URLEncoder.encode(userEmail, StandardCharsets.UTF_8.toString())
                    navController.navigate("home/$encodedName/$encodedEmail") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate("register")
                }
            )
        }


        composable("register") {
            RegisterScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onRegisterSuccess = { userName, userEmail ->
                    val encodedName = URLEncoder.encode(userName, StandardCharsets.UTF_8.toString())
                    val encodedEmail =
                        URLEncoder.encode(userEmail, StandardCharsets.UTF_8.toString())
                    navController.navigate("profile_selection/$encodedName/$encodedEmail") {
                        popUpTo("register") { inclusive = true }
                    }
                }
            )
        }

        composable(
            route = "profile_selection/{userName}/{userEmail}",
            arguments = listOf(
                navArgument("userName") { type = NavType.StringType },
                navArgument("userEmail") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: "Usuário"
            val userEmail = backStackEntry.arguments?.getString("userEmail") ?: "sem@email.com"

            ProfileSelectionScreen(
                onProfileSelected = {
                    val encodedName = URLEncoder.encode(userName, StandardCharsets.UTF_8.toString())
                    val encodedEmail =
                        URLEncoder.encode(userEmail, StandardCharsets.UTF_8.toString())
                    navController.navigate("home/$encodedName/$encodedEmail") {
                        popUpTo("profile_selection") { inclusive = true }
                    }
                }
            )
        }

        composable(
            route = "home/{userName}/{userEmail}",
            arguments = listOf(
                navArgument("userName") { type = NavType.StringType },
                navArgument("userEmail") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: "Usuário"
            val userEmail = backStackEntry.arguments?.getString("userEmail") ?: "sem@email.com"

            HomeScreen(
                navController = navController,
                userName = userName,
                userEmail = userEmail
            )
        }

        composable(
            route = "profile/{userName}/{userEmail}",
            arguments = listOf(
                navArgument("userName") { type = NavType.StringType },
                navArgument("userEmail") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: "Usuário"
            val userEmail = backStackEntry.arguments?.getString("userEmail") ?: "sem@email.com"

            ProfileScreen(
                userName = userName,  // Corrigido
                userEmail = userEmail,  // Corrigido
                onNameChanged = { _ ->
                },
                onSaveClick = {
                    navController.popBackStack()
                }
            )
        }

        composable("dashboard") {
            DashboardScreen(navController = navController)
        }

        composable("feedbackForm") {
            FeedbackScreen(navController = navController)
        }

        composable("feedbackHistory") {
            FeedbackHistoryScreen(navController = navController)
        }
    }
}

