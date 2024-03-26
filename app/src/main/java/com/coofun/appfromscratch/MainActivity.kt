package com.coofun.appfromscratch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coofun.appfromscratch.pages.ForgotPassword
import com.coofun.appfromscratch.pages.Login
import com.coofun.appfromscratch.pages.Signup
import com.coofun.appfromscratch.ui.theme.AppfromscratchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppfromscratchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenMain()
                }
            }
        }
    }
}

@Composable
fun ScreenMain() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            Login(navController);
        }
        composable("signup") {
            Signup(navController = navController);
        }
        composable("forgot-password"){
            ForgotPassword(navController = navController)
        }
    }
}