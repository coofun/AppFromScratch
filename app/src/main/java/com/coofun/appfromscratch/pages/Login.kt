package com.coofun.appfromscratch.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.coofun.appfromscratch.component.CustomTopAppBar
import com.coofun.appfromscratch.ui.theme.Purple700

@Composable
fun Login(navController: NavController) {
    Scaffold(topBar = {
        CustomTopAppBar(navController = navController, title = "Login", showBackIcon = true)
    }) { padding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(padding)) {
            ClickableText(
                text = AnnotatedString("Signup here"),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(20.dp),
                onClick = { navController.navigate("signup") },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default,
                    textDecoration = TextDecoration.Underline,
                    color = Purple700
                )
            )

            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val username = remember {
                    mutableStateOf(TextFieldValue())
                }
                val password = remember {
                    mutableStateOf(TextFieldValue())
                }

                Text(
                    text = "Login",
                    style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive)
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(label = { Text(text = "Username") },
                    value = username.value,
                    onValueChange = { username.value = it })

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Password") },
                    value = password.value,
                    onValueChange = { password.value = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = Modifier.height(15.dp))

                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Login")
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                ClickableText(
                    text = AnnotatedString("Forgot Password?"),
                    onClick = { navController.navigate("forgot-password") },
                    style = TextStyle(
                        fontSize = 15.sp, fontFamily = FontFamily.Default
                    )
                )
            }
        }
    }
}