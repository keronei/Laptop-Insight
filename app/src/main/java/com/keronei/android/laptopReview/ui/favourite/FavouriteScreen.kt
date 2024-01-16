package com.keronei.android.laptopReview.ui.favourite

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FavouriteScreen(favouriteViewModel: FavouriteViewModel = viewModel(), modifier: Modifier = Modifier) {
  Column(modifier = modifier) {
      Text(text = "Favourite Screen")
  }
}