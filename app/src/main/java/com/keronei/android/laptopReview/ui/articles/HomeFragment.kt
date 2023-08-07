package com.keronei.android.laptopReview.ui.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.keronei.android.laptopReview.extensions.navigate
import com.keronei.android.laptopReview.ui.articles.state.ArticlesState
import com.keronei.android.laptopReview.ui.articles.widgets.ArticleView
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel by viewModel<ArticlesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            setContent {
                val articles = homeViewModel.availableArticles.collectAsState()

                when (val list = articles.value) {
                    is ArticlesState.Loading -> {
                        // Show loading
                    }

                    is ArticlesState.Data -> {
                        val items = list.articles

                        LazyColumn(content = {
                            items(items = items) { item ->
                                ArticleView(
                                    item = item,
                                    onSelected = {
                                        homeViewModel.selectedArticle = item

                                        navigate(HomeFragmentDirections
                                            .actionNavigationHomeToArticleDetailFragment())
                                    }
                                )
                            }
                        }, modifier = Modifier.padding(bottom = 56.dp))
                    }

                    is ArticlesState.Empty -> {
                        // Show error
                    }
                }
            }

        }
    }
}