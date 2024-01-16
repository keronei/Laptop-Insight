package com.keronei.android.laptopReview.ui

import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.keronei.android.laptopReview.ui.articles.ArticlesViewModel
import com.keronei.android.laptopReview.ui.articles.HomeFragment
import com.keronei.android.laptopReview.ui.favourite.FavouriteScreen

@Composable
fun MainScreen(navController: NavController, articlesViewModel: ArticlesViewModel) {
    val navigationBarItems = remember { NavigationBarItems.values() }
    var currentScreen by remember {
        mutableStateOf<Screen>(Screen.Home)
    }
    var selectedIndex by remember { mutableIntStateOf(0) }
    // val screenDensity = LocalDensity.current.density


    Scaffold(
        bottomBar = {
            AnimatedNavigationBar(
                modifier = Modifier
                    .height(64.dp)
                    .padding(6.dp),
                selectedIndex = selectedIndex,
                cornerRadius = shapeCornerRadius(cornerRadius = 12.dp),
                ballAnimation = Parabolic(tween(300)),
                indentAnimation = Height(tween(300)),
                barColor = MaterialTheme.colorScheme.primary,
                ballColor = MaterialTheme.colorScheme.primary,

                ) {

                navigationBarItems.forEach { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .noRippleClickable {
                                selectedIndex = item.ordinal

                                currentScreen = when (item) {
                                    NavigationBarItems.Home -> Screen.Home
                                    NavigationBarItems.Favourite -> Screen.Favourite
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            imageVector = item.icon,
                            contentDescription = "Bar Icon",
                            tint = if (selectedIndex == item.ordinal)
                                MaterialTheme.colorScheme.onPrimary
                            else
                                MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }

            }
        }
    ) {
        when (currentScreen) {
            Screen.Home -> {
                HomeFragment(articlesViewModel = articlesViewModel, modifier = Modifier.padding(it))
            }

            Screen.Favourite -> {
                FavouriteScreen(modifier = Modifier.padding(it))
            }
        }
    }
}

enum class NavigationBarItems(val icon: ImageVector) {
    Home(icon = Icons.Default.Home),
    Favourite(icon = Icons.Default.Favorite)
}

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
    ) {
        onClick()
    }
}

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favourite : Screen("favourite")
}