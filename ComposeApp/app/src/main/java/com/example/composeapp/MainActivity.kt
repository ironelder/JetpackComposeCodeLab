package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme
import com.example.composeapp.ui.theme.Purple200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApp {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun MyComposeApp(content : @Composable () -> Unit) {
    ComposeAppTheme {
        // A surface container using the 'background' color from the theme
        //MaterialTheme.colors.background
        Surface(color = Purple200) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
    Text(text = "Hllo $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeApp {
        Greeting("Android")
    }
}