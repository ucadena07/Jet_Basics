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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Surface(
        color = Color.LightGray,
        modifier = Modifier.fillMaxSize()
    ) {

        ProfileCard()
    }
}

@Composable
fun ProfileCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .padding(16.dp)
        ,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            ProfilePicture()
            ProfileContent()
        }
    }
}
@Composable
fun ProfilePicture(){
    Card(
        shape = CircleShape,
        border = BorderStroke(width = 2.dp,color = MaterialTheme.colorScheme.lightGreen.copy(.8f)),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),

    ) {
        Image(
            painter = painterResource(id = R.drawable.user1),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(72.dp)
        )
    }

}
@Composable
fun ProfileContent(){
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Text(text = "John Doe", style = MaterialTheme.typography.headlineSmall)
        Text(
            text = "Active Now",
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

