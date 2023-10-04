package com.danc.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danc.composearticle.ui.theme.ComposeArticleTheme

val colorLists = listOf<Color>(Color(0xFFEADDFF), Color(0xFFD0BCFF), Color(0xFFB69DF8), Color(0xFFF6EDFF))

class QuadrantActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WholeQuadrant()
                }
            }
        }
    }
}


@Composable
fun PartOfQuadrant(
    index: Int,
    title: String,
    body: String,
    modifier: Modifier){
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(colorLists[index])
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun WholeQuadrant(){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Row (Modifier.weight(1f)){
            PartOfQuadrant(
                index = 0,
                title = stringResource(id = R.string.text_composable),
                body = stringResource(id = R.string.text_content),
                modifier = Modifier.weight(1f))

            PartOfQuadrant(
                index = 1,
                title = stringResource(id = R.string.image_composable),
                body = stringResource(id = R.string.image_content),
                modifier = Modifier.weight(1f))
        }
        Row (Modifier.weight(1f)){
            PartOfQuadrant(
                index = 2,
                title = stringResource(id = R.string.text_composable),
                body = stringResource(id = R.string.text_content),
                modifier = Modifier.weight(1f))

            PartOfQuadrant(
                index = 3,
                title = stringResource(id = R.string.image_composable),
                body = stringResource(id = R.string.image_content),
                modifier = Modifier.weight(1f))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun QuadrantAppPreview() {
    ComposeArticleTheme {
        WholeQuadrant()
    }
}