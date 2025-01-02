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
import com.keronei.android.laptopReview.ui.favourite.FavouriteViewModel
import org.koin.androidx.viewmodel.ext.android.getStateViewModel

class MainActivity : ComponentActivity() {
    private lateinit var articleViewModel: ArticlesViewModel
    private lateinit var favouriteViewModel: FavouriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        articleViewModel = getStateViewModel()
        favouriteViewModel = getStateViewModel()

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    MainScreen(navController, articleViewModel, favouriteViewModel)
                }

                composable("articleDetail") {
                    ArticleDetailScreen(articlesViewModel = articleViewModel, favouriteViewModel)
                }
            }
        }
    }
}