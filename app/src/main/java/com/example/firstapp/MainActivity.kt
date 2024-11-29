package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    val nameInput = remember { mutableStateOf("")}
    val displayedText=remember{ mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        TextField(
            value = nameInput.value,
            onValueChange = {nameInput.value=it},
            label = {Text("Enter your name")},
            modifier = Modifier.padding(bottom = 16.dp)
        )


        Button(
            onClick = {
                displayedText.value="Your name is ${nameInput.value}"
            },
        ) {
            Text(text = "Press")
        }
        Text(text = if(displayedText.value.isNotEmpty())
            displayedText.value
        else "")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstAppTheme {
        Greeting()
    }
}