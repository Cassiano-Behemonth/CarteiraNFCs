package com.example.carteiranfcs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carteiranfcs.ui.theme.CarteiraNFCsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarteiraNFCsTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "carteira"
                    ) {
                        composable("carteira") { CarteiraScreen(navController) }
                        composable("wallet2") { CarteiraScreen2() }
                    }
                }
            }
        }
    }
}

@Composable
fun CarteiraScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, start = 16.dp, end = 16.dp)
    ) {
        AvatarBadge(modifier = Modifier.align(Alignment.TopEnd))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_nfc),
                contentDescription = "NFC",
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .size(width = 300.dp, height = 180.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFF9C295B))
            ) {
                TextosCartao()
            }

            Spacer(modifier = Modifier.height(40.dp))

            Row {
                repeat(5) { index ->
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .padding(4.dp)
                            .clip(CircleShape)
                            .background(if (index == 0) Color.Blue else Color.Gray)
                    )
                }
            }
        }
    }
}

@Composable
fun CarteiraScreen2() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Carteira",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            AvatarBadge()
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_cartao),
                contentDescription = "Cartão"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(5) { index ->
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(if (index == 1) Color.Blue else Color.Gray)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            BotaoOpcao(Color(0xFFFFF1CC), R.drawable.ic_shop, "Shop")
            BotaoOpcao(Color(0xFFE1F8E5), R.drawable.ic_food, "Cartão alimentação")
            BotaoOpcao(Color(0xFFFCE4EC), R.drawable.ic_extract, "Extrato")
        }
    }
}

