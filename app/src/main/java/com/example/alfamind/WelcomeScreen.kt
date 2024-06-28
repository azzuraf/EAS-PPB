package com.example.alfamind

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top part with image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFEA0A2A), shape = RoundedCornerShape(bottomEnd = 70.dp, bottomStart = 70.dp))
                    .height(250.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(600.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Welcome Text
            Text(
                text = "Selamat Datang",
                color = Color(0xFFEA0A2A),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Description Text
            Text(
                text = "Toko retail virtual dan platform commerce dari ALFAMART yang bisa kamu miliki untuk mendapatkan penghasilan hanya dengan modal smartphone saja!",
                color = Color.Gray,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 20.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(90.dp))

            // Login Button
            Button(
                onClick = { navController.navigate("login") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(50),
                border = BorderStroke(1.dp, Color(0xFFEA0A2A)),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
            ) {
                Text(text = "Masuk", color = Color(0xFFEA0A2A), fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Or Text
            Text(text = "ATAU", color = Color(0xFFEA0A2A), fontSize = 16.sp)

            Spacer(modifier = Modifier.height(20.dp))

            // Register Button
            Button(
                onClick = { navController.navigate("sign") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEA0A2A)),
                shape = CircleShape,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
            ) {
                Text(text = "Daftar", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
