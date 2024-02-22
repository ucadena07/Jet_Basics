package com.example.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.basics.model.UserProfile
import com.example.basics.model.userProfileList
import com.example.basics.ui.theme.BasicsTheme
import com.example.basics.ui.theme.lightGreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(topBar = {AppBar()}) {
        Surface(
            color = Color.LightGray,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            LazyColumn{
                items(userProfileList){userProfile ->
                    ProfileCard(userProfile = userProfile)
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(){
    TopAppBar(
        title = { Text(text = "Messaging Application Users") },
        navigationIcon = { Icon(imageVector = Icons.Default.Home, contentDescription = "", modifier =  Modifier.padding(horizontal = 12.dp))}
    )
}


@Composable
fun ProfileCard(userProfile: UserProfile){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
        ,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            ProfilePicture(userProfile.pictureUrl,userProfile.status)
            ProfileContent(userProfile.name, userProfile.status)
        }
    }
}
@Composable
fun ProfilePicture(imageUrl: String, onlineStatus: Boolean){
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if(onlineStatus)
                        lightGreen.copy(.8f)
                    else
                        Color.Red
        ),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),

    ) {
        
        AsyncImage(
            model = imageUrl,
            contentDescription = "image",
            contentScale = ContentScale.Crop,

            modifier = Modifier.clip(CircleShape).size(72.dp)

        )
    }

}
@Composable
fun ProfileContent(name: String, onlineStatus: Boolean){
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Text(text = name, style = MaterialTheme.typography.headlineSmall)
        Text(
            text = if(onlineStatus) "Active Now" else "Offline",
            color = MaterialTheme.colorScheme.secondary.copy(0.5f)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    BasicsTheme {
        MainScreen()
    }

}

