package com.danc.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danc.composearticle.ui.theme.ComposeArticleTheme

class BusinessCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
            , verticalArrangement = Arrangement.Center
        ){
            Column () {
                MainUI_Logo(
                    painter = painterResource(id = R.drawable.android_logo),
                    fullName = "doni",
                    title = "TITLE"
                )
            }
            Column (
                modifier = Modifier.padding(bottom = 40.dp)
            ){
                MainUI_Info()
            }
        }
}

@Composable
fun MainUI_Logo(
    painter: Painter,
    fullName: String,
    title: String,
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .border(1.dp, Color.Red)
            .padding(start = 10.dp, end = 10.dp)
    ){
        Image(painter = painter, contentDescription = "Business Card Photo", modifier = Modifier
            .padding(top = 20.dp, start = 50.dp, end = 50.dp)
            .size(250.dp))
        Text(text = fullName, textAlign = TextAlign.Justify, fontSize = 40.sp, modifier = Modifier.padding(10.dp))
        Text(text = title, fontSize = 30.sp, modifier = Modifier.padding(10.dp))
    }
}

@Composable
fun MainUI_Info(
){
    Column (
        modifier = Modifier
            .padding(top = 50.dp)
            .border(1.dp, Color.Green),
        verticalArrangement = Arrangement.Bottom
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val painter: Painter = painterResource(id = R.drawable.android_logo)
            Image(painter = painter, contentDescription = null, Modifier.size(30.dp))

            Text(text = "+82 010 0000 0000", fontSize = 20.sp)
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val painter: Painter = painterResource(id = R.drawable.android_logo)
            Image(painter = painter, contentDescription = null,
                Modifier
                    .size(30.dp))
            Text(text = "@socialMediaHash", fontSize = 20.sp)
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val painter: Painter = painterResource(id = R.drawable.android_logo)
            Image(painter = painter, contentDescription = null,
                Modifier
                    .size(30.dp))
            Text(text = "dan@gmail.com", fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardApp()
}