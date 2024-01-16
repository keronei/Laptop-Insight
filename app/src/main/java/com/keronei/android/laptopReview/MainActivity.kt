package com.keronei.android.laptopReview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import com.keronei.android.laptopReview.ui.MainScreen
import com.keronei.android.laptopReview.ui.articles.ArticlesViewModel
import org.koin.androidx.viewmodel.ext.android.getStateViewModel

class MainActivity : ComponentActivity() {
    private lateinit var articleViewModel: ArticlesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navController = NavController(this)

        articleViewModel = getStateViewModel()

        setContent {
            MainScreen(navController, articleViewModel)
        }
    }
}