package com.keronei.android.laptopReview.ui.favourite

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FavouriteScreen(
    modifier: Modifier = Modifier,
    favouriteViewModel: FavouriteViewModel = viewModel()
) {
    val favourites by favouriteViewModel.articles.collectAsState()
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Favourites: ${favourites.size}")
    }
}