package com.example.alfamind

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top part with image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFEA0A2A))
                .height(90.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_crop),
                contentDescription = "Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(120.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Title
        Text(
            text = "Masuk Akun",
            color = Color(0xFFEA0A2A),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(70.dp))

        // Username Field
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username atau Email", color = Color(0xFFEA0A2A)) },
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Email, contentDescription = "Email Icon", tint = Color(0xFFEA0A2A))
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFEA0A2A),
                unfocusedBorderColor = Color.Gray
            )
        )

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", color = Color(0xFFEA0A2A)) },
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Lock, contentDescription = "Lock Icon", tint = Color(0xFFEA0A2A))
            },
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else
                    Icons.Filled.VisibilityOff

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = "Toggle Password Visibility", tint = Color(0xFFEA0A2A))
                }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(16.dp, 4.dp,16.dp, 16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFEA0A2A),
                unfocusedBorderColor = Color.Gray
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { /* Handle on done */ }
            )
        )

        // Login Button
        Button(
            onClick = { navController.navigate("shopping") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEA0A2A)),
            shape = CircleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 20.dp, 16.dp, 0.dp)
                .height(50.dp)

        ) {
            Text(text = "Masuk", color = Color.White)
        }


        // Register Text
        TextButton(onClick = { navController.navigate("sign") }) {
            Text(
                text = "Tidak punya akun? Daftar Disini!",
                color = Color(0xFFEA0A2A)
            )
        }
    }
}
