package com.example.alfamind

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.ui.text.font.FontWeight

@Composable
fun TopUpScreen(navController: NavController) {
    var selectedAmount by remember { mutableStateOf("") }
    var customAmount by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFEA0A2A))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Top Up",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Custom Amount Input
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color(0xFFF5E5E5), RoundedCornerShape(16.dp))
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                TextField(
                    value = customAmount,
                    onValueChange = { customAmount = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.White, RoundedCornerShape(8.dp)),
                    placeholder = { Text(text = "Enter amount") },
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.White,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent
//                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Predefined Amount Buttons
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AmountButton(amount = "20.000", selectedAmount) { selectedAmount = it }
                    AmountButton(amount = "50.000", selectedAmount) { selectedAmount = it }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AmountButton(amount = "100.000", selectedAmount) { selectedAmount = it }
                    AmountButton(amount = "200.000", selectedAmount) { selectedAmount = it }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AmountButton(amount = "500.000", selectedAmount) { selectedAmount = it }
                    AmountButton(amount = "1.000.000", selectedAmount) { selectedAmount = it }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Pay Button
        Button(
            onClick = { /* Handle payment action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEA0A2A)),
            shape = CircleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(50.dp)
        ) {
            Text(text = "Bayar", color = Color.White)
        }

        Spacer(modifier = Modifier.height(220.dp))

        // Bottom navigation bar
        BottomNavigationBar(navController)
    }
}

@Composable
fun AmountButton(amount: String, selectedAmount: String, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(amount) },
        colors = if (selectedAmount == amount) {
            ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color(0xFFEA0A2A))
        } else {
            ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5F5), contentColor = Color.Black)
        },
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .width(150.dp)
            .border(1.dp, if (selectedAmount == amount) Color(0xFFEA0A2A) else Color.Transparent, RoundedCornerShape(20.dp))
    ) {
        Text(text = amount, textAlign = TextAlign.Center)
    }
}
