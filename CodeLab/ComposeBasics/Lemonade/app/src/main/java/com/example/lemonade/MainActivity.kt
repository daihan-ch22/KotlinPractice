package com.example.lemonade

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
fun LemonadeAppPreview() {
    LemonadeApp()
}

@Composable
fun LemonadeApp() {
    LemonadeContents()
}


@Composable
fun LemonadeContents() {

    // current stage
    var currentStage: Int by remember {
        mutableStateOf(1)
    }

    // squeezed count
    var squeezedCount: Int by remember {
        mutableStateOf(0)
    }

    when (currentStage) {
        1 -> {
            Container(
                imageResourceId = R.drawable.lemon_tree,
                textResourceId = R.string.TAP_LEMON,
                imageDescriptionId = R.string.LEMON_TREE,
                onClick = {
                    currentStage = 2
                    squeezedCount = (2..4).random()
                })
        }

        2 -> {
            var clicked = 0

            Container(
                imageResourceId = R.drawable.lemon_squeeze,
                textResourceId = R.string.KEEP_TAPPING,
                imageDescriptionId = R.string.LEMON,
                onClick = {
                    clicked++
                    Log.d("LEMON", "current clicked $clicked and target count is $squeezedCount")
                    if (clicked == squeezedCount) {
                        currentStage = 3
                    }
                })
        }

        3 -> {
            Container(
                imageResourceId = R.drawable.lemon_drink,
                textResourceId = R.string.TAP_TO_DRINK,
                imageDescriptionId = R.string.GLASS_OF_LEMONADE,
                onClick = {
                    currentStage = 4
                })
        }

        else -> {
            Container(
                imageResourceId = R.drawable.lemon_restart,
                textResourceId = R.string.TAP_EMPTY_GLASS,
                imageDescriptionId = R.string.EMPTY_GLASS,
                onClick = {
                    currentStage = 1
                }
            )
        }
    }
}

@Composable
fun Container(
    modifier: Modifier = Modifier,
    imageResourceId: Int,
    textResourceId: Int,
    imageDescriptionId: Int,
    onClick: () -> Unit,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = modifier.clip(RoundedCornerShape(10.dp))
        ) {
            Button(
                onClick = onClick,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
            ) {
                Image(
                    painter = painterResource(id = imageResourceId),
                    contentDescription = stringResource(id = imageDescriptionId),
                    modifier
                        .background(Color.Cyan)
                        .size(200.dp)
                        .padding(10.dp)
                )
            }
        }
        Spacer(modifier = modifier.size(16.dp))
        Text(
            text = stringResource(id = textResourceId),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

