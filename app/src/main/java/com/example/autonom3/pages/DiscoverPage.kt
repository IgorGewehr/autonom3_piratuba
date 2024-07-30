package com.example.autonom3.pages

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.autonom3.R
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun DiscoverPage(modifier: Modifier = Modifier){
    Scaffold (
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.logo_piratuba),
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center)
                            .padding(end = 25.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            )
        }
    ){innerPadding ->
        Box(modifier = Modifier.padding(innerPadding))
    }
}