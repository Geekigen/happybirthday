package com.example.testjetpack

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.testjetpack.ui.theme.TestJetpackTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestJetpackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        message = "Hello Kigen",
                        from = "From Caleb",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(message: String , from: String,modifier: Modifier = Modifier) {
       Column(
           verticalArrangement = Arrangement.Center,
           modifier = Modifier
       ){

           Text(
               text = message,
               fontSize = 100.sp,
               lineHeight = 160.sp,
               textAlign = TextAlign.Center,
               modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
           )
           Text(text = from,
               fontSize = 36.sp,
               lineHeight = 50.sp,
               modifier = Modifier
                   .padding(16.dp)
                   .align(alignment = Alignment.CenterHorizontally)
           )
       }

}
@Composable
fun GreetingImage(message: String,from: String,modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F

        )
    }
    Greeting(
        message = message,
        from = from,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestJetpackTheme {
        GreetingImage("Happy birthday ", "From Kigen")
    }
}