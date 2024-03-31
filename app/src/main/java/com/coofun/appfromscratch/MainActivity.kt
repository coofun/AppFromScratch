package com.coofun.appfromscratch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coofun.appfromscratch.codelab.soothe.SootheApp
import com.coofun.appfromscratch.pages.ForgotPassword
import com.coofun.appfromscratch.pages.Login
import com.coofun.appfromscratch.pages.Signup
import com.coofun.appfromscratch.ui.theme.AppFromScratchTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(activity = this)
            AppFromScratchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenMain(windowSizeClass)
                }
            }
        }
    }
}

@Composable
fun ScreenMain(windowSize: WindowSizeClass) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            SootheApp(navController = navController, windowSize = windowSize)
        }
        composable("login") {
            Login(navController = navController)
        }
        composable("signup") {
            Signup(navController = navController)
        }
        composable("forgot-password") {
            ForgotPassword(navController = navController)
        }
    }
}