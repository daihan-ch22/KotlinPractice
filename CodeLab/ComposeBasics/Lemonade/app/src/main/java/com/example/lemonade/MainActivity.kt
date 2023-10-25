package com.example.lemonade

import android.os.Bundle
import android.view.RoundedCorner
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun LemonadeAppPreview(){
    LemonadeApp()
}

@Composable
fun LemonadeApp(){
    LemonadeContents()
}


@Composable
fun LemonadeContents(
    modifier: Modifier = Modifier
){

    // current stage
    var currentStage = 1

    when(currentStage){
        1 -> {
            Container(
                modifier = modifier,
                image = painterResource(id = R.drawable.lemon_tree),
                description = stringResource(id = R.string.LEMON_TREE),
                currentStage
            )
        }
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
}

@Composable
fun Container(
    modifier: Modifier,
    image: Painter,
    description: String,
    currentStep: Int
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Box(
            modifier = modifier.clip(RoundedCornerShape(10.dp))
        ) {

            Image(painter = image, contentDescription = description,
                modifier
                    .background(Color.Cyan)
                    .size(200.dp)
                    .padding(10.dp)
                    .clickable {
                        //TODO: when click the image
                    })
        }

        Spacer(modifier = modifier.size(16.dp))

        Text(text = stringResource(id = R.string.TAP_LEMON), fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}

