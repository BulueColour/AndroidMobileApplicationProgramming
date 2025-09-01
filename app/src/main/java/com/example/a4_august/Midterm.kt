package com.example.a4_august

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a4_august.ui.theme._4_AugustTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType

class Midterm : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _4_AugustTheme {
                BirthdayCardApp()
            }
        }
    }
}

@Composable
fun BirthdayCardApp() { //สร้างฟอร์มเพื่อกรอกข้อมูลแล้วส่วนไปแสดงหน้า screen
    var currentScreen by remember { mutableStateOf("input") }
    var name by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var from by remember { mutableStateOf("") }

    when (currentScreen) {
        "input" -> {
            InputScreen(
                name = name,
                date = date,
                from = from,
                onNameChange = { name = it },
                onDateChange = { date = it },
                onFromChange = { from = it },
                onCreateClick = {
                    if (name.isNotBlank() && date.isNotBlank() && from.isNotBlank()) {
                        currentScreen = "card"
                    }
                }
            )
        }
        "card" -> {
            Card(
                message = "Happy Birthday\n$name!",
                from = "Date: $date\nFrom: $from"
            )
        }
    }
}

@Composable
fun InputScreen(
    name: String,
    date: String,
    from: String,
    onNameChange: (String) -> Unit,
    onDateChange: (String) -> Unit,
    onFromChange: (String) -> Unit,
    onCreateClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.firstPageTitle),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        )

        Text(
            text = stringResource(R.string.firstBulletTitle),
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            placeholder = { Text("Enter Your Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Gray
            )
        )

        Text(
            text = stringResource(R.string.secondBulletTitle),
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = date,
            onValueChange = onDateChange,
            placeholder = { Text("Enter date Ex. 18-03-2568") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Gray
            )
        )

        Text(
            text = "From:",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = from,
            onValueChange = onFromChange,
            placeholder = { Text("Enter Your Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Gray
            )
        )

        Button(
            onClick = onCreateClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Create",
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

// ใช้ฟังก์ชัน Card เดิมจาก BulueColour.kt
@Composable
fun Card(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = message,
            fontSize = 80.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
        Text(
            text = from,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.End)
        )
        Text(
            text = "62050237 Sittipong buntean",
            fontSize = 14.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.End)
        )
    }
}

@Composable
fun CardImage(message: String, from: String, modifier: Modifier = Modifier) {
    val img = painterResource(id = R.drawable.corgi_smile)
    Box(
        modifier.fillMaxSize()
    ) {
        Image(
            painter = img,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Card(message = message, from = from)
    }
}

@Preview(showBackground = true)
@Composable
fun MidtermPreview() {
    _4_AugustTheme {
        BirthdayCardApp()
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    Surface(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
    ) {
        _4_AugustTheme {
            CardImage("Happy birthday", "It's your day, enjoy!")
        }
    }
}