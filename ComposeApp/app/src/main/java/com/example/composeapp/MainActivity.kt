package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme
import com.example.composeapp.ui.theme.Purple200
import com.example.composeapp.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApp {
                TestContent()
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
fun TestContent(names : List<String> = listOf("test", "meet", "nice", "Android", "hola")) {
    Column {
        for (name in names){
            Greeting(name)
//            Text(text = name, modifier = Modifier.padding(10.dp), textAlign = TextAlign.Center)
            Divider(color = Teal200)
        }
        Divider(color = Color.Black, thickness = 3.dp)
        CounterButton()
    }
}

@Composable
fun CounterButton() {
    val counter = remember {
        mutableStateOf(0)
    }

    Button(onClick = {
        counter.value++
    }) {
        Text(text = "Button Click Count = ${counter.value}")
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
        Divider(color = Teal200)
        Text(text = "Hllo $name!")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeApp {
        Greeting("Android")
    }
}