package com.vyns.mvvmjetpackcomposesample.ui.app.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import com.vyns.mvvmjetpackcomposesample.data.model.MovieItem
import com.vyns.mvvmjetpackcomposesample.utils.Constants

@Composable
fun MovieDetails(movieItem: MovieItem){
    Column() {
            MovieDetailsBanner(movieItem = movieItem)
            MovieDetailsText(movieItem = movieItem)
    }
}

@Composable
fun MovieDetailsBanner(movieItem: MovieItem){
   Row(modifier = Modifier
       .fillMaxWidth()
       .height(300.dp)) {
       Image(modifier = Modifier
           .fillMaxWidth()
           .fillMaxHeight(),painter = rememberCoilPainter(request = Constants.BASE_IMAGE_URL+movieItem.backdrop_path) , contentDescription = "")
   }
}
@Composable
fun MovieDetailsText(movieItem: MovieItem){
    Column(modifier = Modifier.padding(10.dp)) {
        movieItem.title?.let {
            Text(text = it, fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp)
        }
        Text(text = movieItem.overview,Modifier.padding(top=10.dp),fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp)
    }

}