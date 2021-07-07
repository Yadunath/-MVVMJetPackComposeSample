package com.vyns.mvvmjetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vyns.mvvmjetpackcomposesample.ui.app.MainList
import com.vyns.mvvmjetpackcomposesample.ui.app.details.MovieDetails
import com.vyns.mvvmjetpackcomposesample.ui.theme.MVVMJetPackComposeSampleTheme
import com.vyns.mvvmjetpackcomposesample.ui.viewmodel.MainViewModel


class MainActivity : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MVVMJetPackComposeSampleTheme {
                NavHost(navController = navController, startDestination = "trendingMovieList") {
                    composable("trendingMovieList") {
                        Surface(color = MaterialTheme.colors.background) {
                            MainList(navController = navController, mainViewModel = mainViewModel)
                        }
                    }
                    composable("movieDetails") {
                        MovieDetails(mainViewModel.clickedItem)
                    }
                }
                // A surface container using the 'background' color from the theme

            }
        }
    }
}
