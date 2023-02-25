package com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.domain.model.Character
import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.ui.theme.Devsavant_Android_networking_challengePublicTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Devsavant_Android_networking_challengePublicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val characters by viewModel.characters.collectAsState()
                    val isLoading by viewModel.isLoading.collectAsState()
                    val isErrorConnectingToServer by viewModel.errorConnectingToServer.collectAsState()

                    Column(modifier = Modifier.fillMaxSize()) {
                        Header(
                            onFetchClicked = {
                                viewModel.fetchCharacters()
                            },
                            onClearClicked = {
                                viewModel.clearCharacter()
                            }
                        )
                        if (isErrorConnectingToServer) {
                            ErrorConnectingToServerMessage()
                        }
                        if (isLoading) {
                            Loading()
                        } else {
                            CharacterList(characters = characters)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Header(onFetchClicked: () -> Unit, onClearClicked: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "NetworkConnect")
        Row() {
            Button(
                onClick = {
                    onFetchClicked()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background)
            ) {
                Text(text = "FETCH")
            }
            Button(
                onClick = {
                    onClearClicked()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background)
            ) {
                Text(text = "CLEAR")
            }
        }
    }
}

@Composable
fun ErrorConnectingToServerMessage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Error connecting to server, Check your internet connection.",
            color = Color.Red,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Loading() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun CharacterList(characters: List<Character>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(characters) { character ->
            CharacterItem(character)
        }
    }
}

@Composable
fun CharacterItem(character: Character) {
    Card(elevation = 4.dp) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = "Character image",
                modifier = Modifier
                    .padding(8.dp)
                    .size(84.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            )
            Text(
                text = character.name,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
