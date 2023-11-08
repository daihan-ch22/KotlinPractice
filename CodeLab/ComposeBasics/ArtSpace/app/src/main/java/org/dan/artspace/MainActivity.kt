package org.dan.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun ArtSpaceAppPreview(){
    ArtSpaceApp()
}

@Composable
fun ArtSpaceApp(){

    val artIndex by remember {
        mutableStateOf(1)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        //ART FRAME
        ArtFrame(artIndex = artIndex)

        //ART DESCRIPTION
        ArtDescription(artIndex = artIndex)

        //BUTTON
        ArtSwitchButton(artIndex = artIndex)
    }
}

@Composable
fun ArtFrame(
    artIndex: Int
){
    val painterResource = when(artIndex){
        1 -> painterResource(id = R.drawable.mona)
        2 -> painterResource(id = R.drawable.girlwithapearl)
        else -> painterResource(id = R.drawable.starrynight)
    }
    val description = when(artIndex){
        1 -> "Mona Lisa"
        2 -> "Girl with a pearl earring"
        else -> "Starry Night"
    }
    Column(
        modifier = Modifier
            .padding(20.dp)
            .size(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource,
            contentDescription = description)
    }
}

@Composable
fun ArtDescription(
    artIndex: Int
){
    val artTitle = when(artIndex){
        1 -> stringResource(id = R.string.mona)
        2 -> stringResource(id = R.string.girl_with_a_pearl_earring)
        else -> stringResource(id = R.string.the_starry_night)
    }
    val artist = when(artIndex){
        1 -> stringResource(id = R.string.mona_artist)
        2 -> stringResource(id = R.string.girl_with_a_pearl_artist)
        else -> stringResource(id = R.string.the_starry_night_artist)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        //TITLE
        Column(modifier = Modifier) {
            Text(text = artTitle)
        }

        //DETAILS
        Column(modifier = Modifier) {
            Text(text = artist)
        }
    }
}

@Composable
fun ArtSwitchButton(
    artIndex: Int
){
    Row(
    ) {
        //PREVIOUS BUTTON
        Button(onClick = {

        }, modifier = Modifier.weight(1f)) {
           Text(text = "previous") 
        }

        //NEXT BUTTON
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.weight(1f)) {
            Text(text = "next")
        }
    }
}