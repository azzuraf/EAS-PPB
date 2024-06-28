package com.example.alfamind

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.GridOn
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text

data class Product(val imageRes: Int, val name: String, val price: String)

val products = listOf(
    Product(R.drawable.hoodie, "Hoodie Pink", "RP 90.000,-"),
    Product(R.drawable.jaket, "Jaket Kulit", "RP 250.000,-"),
    Product(R.drawable.jeans, "Jeans Biru", "RP 199.000,-"),
    Product(R.drawable.kemeja, "Kemeja", "RP 80.000,-")
)

@Composable
fun ShoppingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
                text = "Shopping",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Filter section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "FILTER",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { /* Handle filter click */ }
                )
                Icon(
                    imageVector = Icons.Outlined.FilterList,
                    contentDescription = "Filter Icon",
                    tint = Color.Black,
                    modifier = Modifier.clickable { /* Handle filter click */ }
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.GridOn,
                    contentDescription = "Grid View Icon",
                    tint = Color.Black,
                    modifier = Modifier.clickable { /* Handle grid view click */ }
                )
                Icon(
                    imageVector = Icons.Outlined.List,
                    contentDescription = "List View Icon",
                    tint = Color.Black,
                    modifier = Modifier.clickable { /* Handle list view click */ }
                )
            }
        }

        // Tab section
        TabRow(
            selectedTabIndex = 0,
            contentColor = Color(0xFFEA0A2A)
        ) {
            Tab(
                selected = true,
                onClick = { /* Handle tab click */ },
                text = { Text("Populer") }
            )
            Tab(
                selected = false,
                onClick = { /* Handle tab click */ },
                text = { Text("Pria") }
            )
            Tab(
                selected = false,
                onClick = { /* Handle tab click */ },
                text = { Text("Wanita") }
            )
            Tab(
                selected = false,
                onClick = { /* Handle tab click */ },
                text = { Text("Diskon") }
            )
        }

        // Product grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(products.size) { index ->
                val product = products[index]
                ProductCard(
                    imageRes = product.imageRes,
                    name = product.name,
                    price = product.price
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Bottom navigation bar
        BottomNavigationBar(navController)
    }
}

@Composable
fun ProductCard(imageRes: Int, name: String, price: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xE1C1C5)),
        modifier = Modifier
            .width(120.dp)
            .height(250.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Product Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(150.dp)
            )
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 24.sp,)
            Text(text = price, color = Color.Red, fontSize = 16.sp,)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color(0xFFEA0A2A)
    ) {
        BottomNavigationItem(
            selected = navController.currentDestination?.route == "shopping",
            onClick = { navController.navigate("shopping") { launchSingleTop = true } },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.cart_fill), // Replace with your actual icon resource
                    contentDescription = "Shopping Icon",
                    modifier = Modifier.size(30.dp)
                )
            },
            label = { Text("Shopping") }
        )
        BottomNavigationItem(
            selected = navController.currentDestination?.route == "topup",
            onClick = { navController.navigate("topup") { launchSingleTop = true } },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.topup_fill), // Replace with your actual icon resource
                    contentDescription = "Top Up Icon",
                    modifier = Modifier.size(30.dp)
                )
            },
            label = { Text("Top Up") }
        )
        BottomNavigationItem(
            selected = navController.currentDestination?.route == "profile",
            onClick = { navController.navigate("profile") { launchSingleTop = true } },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.profile_fill), // Replace with your actual icon resource
                    contentDescription = "Profile Icon",
                    modifier = Modifier.size(30.dp)
                )
            },
            label = { Text("Profile") }
        )
    }
}