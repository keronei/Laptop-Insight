package com.keronei.android.laptopReview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.keronei.android.laptopReview.ui.MainScreen
import com.keronei.android.laptopReview.ui.articles.ArticlesViewModel
import com.keronei.android.laptopReview.ui.articles.widgets.ArticleDetailScreen
import com.keronei.android.laptopReview.ui.favourite.FavoriteDetailScreen
import com.keronei.android.laptopReview.ui.favourite.FavouriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private  val articleViewModel: ArticlesViewModel by viewModel()
    private  val favouriteViewModel: FavouriteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    MainScreen(navController, articleViewModel, favouriteViewModel)
                }

                composable("articleDetail") {
                    ArticleDetailScreen(articlesViewModel = articleViewModel, favouriteViewModel)
                }

                composable("favDetail") {
                    FavoriteDetailScreen(favouriteViewModel = favouriteViewModel)
                }
            }
        }
    }
}