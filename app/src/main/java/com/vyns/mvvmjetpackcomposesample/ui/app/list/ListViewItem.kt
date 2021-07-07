package com.vyns.mvvmjetpackcomposesample.ui.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.transform.CircleCropTransformation
import com.google.accompanist.coil.rememberCoilPainter
import com.vyns.mvvmjetpackcomposesample.data.model.MovieItem
import com.vyns.mvvmjetpackcomposesample.utils.Constants

@Composable
fun ListViewItem(
    navController: NavController,
    movieItem: MovieItem,
    onItemClicked: (item: MovieItem) -> Unit
) {
    ListViewItem(movieItem = movieItem, modifier = Modifier
        .padding(8.dp)
        .clickable {
            onItemClicked(movieItem)
            navController.navigate("movieDetails")
        })
}

@Composable
fun ListViewItem(
    movieItem: MovieItem, modifier: Modifier
) {
    Card(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            MovieImageBanner(imagePath = movieItem.backdrop_path)
            MovieMetadataItem(movieItem = movieItem)
        }
    }
}

@Composable
fun MovieImageBanner(imagePath: String) {

    Image(
        modifier = Modifier
            .width(180.dp)
            .height(100.dp), painter = rememberCoilPainter(
            request = Constants.BASE_IMAGE_URL + imagePath
        ),
        contentDescription = ""
    )

}

@Composable
fun MovieMetadataItem(movieItem: MovieItem) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp)
    ) {
        movieItem?.title?.let {
            Text(
                text = it
            )
            Text(
                text = movieItem.vote_average,
                style = MaterialTheme.typography.body1
            )
        }

    }
}
