package com.example.a4_august

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Article() {
    Column {
        val image = painterResource(id = R.drawable.bg_compose_background)

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(painter = image, contentDescription = null)
            Text(
                text = "Jetpack Compose Tutorial",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp) //padding สามารถ custom ได้ ซึ่งมี start, end, top, bottom
            )
            Text(
                text = stringResource(R.string.SecondParagraph), //เก็บข้อความอยู๋ใน res/values/strings.xml
                textAlign = TextAlign.Justify, //จัด text ให้เท่ากันทั้งหมด
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = stringResource(R.string.ThirdParagraph),
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewArticle() {
    Article()
}