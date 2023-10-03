package com.danc.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danc.composearticle.ui.theme.ComposeArticleTheme

lateinit var title: String
lateinit var abstractMsg: String
lateinit var bodyMsg: String
lateinit var image: Painter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ContentInit()

            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainAppFeatures()
                }
            }
        }
    }
}


@Composable
fun MainAppFeatures(modifier: Modifier = Modifier){
    Column (modifier = modifier) {
        Image(painter = image, contentDescription = null)

        Text(text = title, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Text(text = abstractMsg, modifier = Modifier.padding(start = 16.dp, end = 16.dp), textAlign = TextAlign.Justify )
        Text(text = bodyMsg, modifier = Modifier.padding(16.dp), textAlign = TextAlign.Justify)
    }
}

@Composable
fun ContentInit(){
    //init
    title = stringResource(id = R.string.title)
    abstractMsg = stringResource(id = R.string.abstractMsg)
    bodyMsg = stringResource(id = R.string.bodyMsg)
    image = painterResource(id = R.drawable.bg_compose_background)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {

        ContentInit()

        MainAppFeatures()
    }
}