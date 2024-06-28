package com.example.alfamind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "splash") {
                composable("splash") { SplashScreen(navController) }
                composable("welcome") { WelcomeScreen(navController) }
                composable("login") { LoginScreen(navController) }
                composable("sign") { SignScreen(navController) }
                composable("shopping") { ShoppingScreen(navController) }
                composable("topup") { TopUpScreen(navController) }
                composable("profile") { ProfileScreen(navController) }

            }
        }
    }
}
