package org.dan.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.dan.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(){

    //ART FRAME
    val artId by remember { mutableStateOf("1") }
    val contentDescriptionId by remember { mutableStateOf("1") }

    //ART DESCRIPTION

    //BUTTON
    val currentArtId by remember { mutableStateOf(1) }


    ArtFrame()
    Spacer(modifier = Modifier)
    ArtDescription()
}

@Composable
fun ArtFrame(
    painterResourceId: Int,
    contentDescriptionId: Int
){
    val contentDescription: String = when(contentDescriptionId){
        1 -> ""
        2 -> ""
        else -> "0"
    }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .size(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = painterResourceId),
            contentDescription = contentDescription)
    }
}

@Composable
fun ArtDescription(
    artTitle: Int,
    artDetail: Int
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        //TITLE
        Column(modifier = Modifier) {
            Text(text = )
        }

        //DETAILS
    }

}

@Composable
fun ArtSwitchButton(){

}