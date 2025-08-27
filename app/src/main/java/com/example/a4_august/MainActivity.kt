package com.example.a4_august

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a4_august.ui.theme._4_AugustTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //ทำงานตรงนี้
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _4_AugustTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {}
            }
        }
    }
}

@Composable
fun Greeting(message: String, from: String, modifier: Modifier = Modifier) { //การสร้างฟังก์ชันด้วย jet compose
    Column(
        verticalArrangement = Arrangement.Center, //ใช้เพื่อจัดให้อยู่ตรงกลาง
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp) //dp ใช้กับหน้าจอ sp ใช้กับ font
    ) {
        Text(
            text = message,
            fontSize = 80.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Left, //ใช้จัดตำแหน่งข้อความ (เช่น center ให้อยู๋กลาง)
            modifier = modifier // ใช้จัดการ layout การตกแต่งต่างๆ
        )
        Text(
            text = from,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) { //การเรียกใช้รูปภาพ
    val image = painterResource(id = R.drawable.androidparty)
    Box(
        modifier.fillMaxSize()
    ) {
        Image(painter = image, contentDescription = null)
        Greeting(message = message, from = from)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Surface(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
    ) {
        _4_AugustTheme {
            GreetingImage("Happy birthday Samuel!", "From Emma")
        }
    }
}