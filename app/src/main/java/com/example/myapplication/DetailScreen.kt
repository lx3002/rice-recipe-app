package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.models.food

@Composable
fun DetailScreen(id:Long, name: String?,onNavigateUp: () -> Unit){
    val recipes = food.first{ it.id == id }
    val scrollState = rememberScrollState()
    Scaffold{
        Column(Modifier.padding(it)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 10.dp),
            ) {
                IconButton(onClick = onNavigateUp) {
                    Icon(Icons.Rounded.ArrowBack, contentDescription = "Go Back")
                }
                Spacer(modifier = Modifier.width(80.dp))
                val link = LocalUriHandler.current
                // Button jetpack compose

                Button(onClick = {
                    link.openUri("https://www.youtube.com/watch?v=Xx7sxWI9FNI")
                }) {
                    Text("this is the way to do it")
                }


            }
            Column(modifier = Modifier.verticalScroll(state = scrollState)) {


                Image(
                    painterResource(recipes.imageResource), contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f), contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1, text = recipes.title
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text("INGERDIENTS....")
                    for (ingredient in recipes.ingredients) {
                        Text(
                            "-$ingredient",
                            style = MaterialTheme.typography.body1,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text("METHOD.....")
                    for (method in recipes.method) {
                        Text(
                            "-$method", modifier = Modifier.fillMaxSize(),
                            style = MaterialTheme.typography.body1,
                        )
                    }
                }
            }
        }
    }
}