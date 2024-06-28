package com.example.alfamind

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
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
                text = "Profile",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Profile Picture
        Image(
            painter = painterResource(id = R.drawable.baun), // Replace with your actual image resource
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(150.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Shop Information
        Text(
            text = "Shop Baun",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Medan Kota, Medan",
            color = Color.Gray,
            fontSize = 16.sp
        )
        Text(
            text = "085686798654",
            color = Color.Gray,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Balance and Rating Information
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.wallet), // Replace with your actual icon resource
                    contentDescription = "Wallet Icon",
                    tint = Color.Red,
                    modifier = Modifier.size(40.dp)
                )
                Text(text = "Saldo", color = Color.Gray, fontSize = 16.sp)
                Text(text = "RP 1.234.000", color = Color.Red, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.rating),
                    contentDescription = "Rating Icon",
                    tint = Color.Red,
                    modifier = Modifier.size(40.dp)
                )
                Text(text = "Rating", color = Color.Gray, fontSize = 16.sp)
                Text(text = "4.95 / 5", color = Color.Red, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "(7893)", color = Color.Gray, fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(235.dp))

        // Bottom navigation bar
        BottomNavigationBar(navController)
    }
}
