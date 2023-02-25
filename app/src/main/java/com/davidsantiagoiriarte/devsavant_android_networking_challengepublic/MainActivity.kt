package com.davidsantiagoiriarte.devsavant_android_networking_challengepublic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.ui.theme.Devsavant_Android_networking_challengePublicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Devsavant_Android_networking_challengePublicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Header()
                }
            }
        }
    }
}

@Composable
fun Header() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "NetworkConnect")
        Row() {
            Button(onClick = {

            }) {
                Text(text = "FETCH")
            }
            Button(onClick = {

            }) {
                Text(text = "CLEAR")
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Devsavant_Android_networking_challengePublicTheme {
        Header()
    }
}