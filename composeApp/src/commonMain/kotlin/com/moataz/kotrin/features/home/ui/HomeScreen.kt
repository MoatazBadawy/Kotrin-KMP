package com.moataz.kotrin.features.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.moataz.kotrin.features.home.ui.components.Black
import com.moataz.kotrin.features.home.ui.components.KotrinToolbar
import com.moataz.kotrin.features.home.ui.components.White50
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    navigateToImages: (objectUrl: String) -> Unit
) {
    val viewModel = koinViewModel<HomeViewModel>()
    val wallpapersState = viewModel.wallpapers.collectAsStateWithLifecycle()
    val isLoading = viewModel.isLoading.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            KotrinToolbar(
                title = "Wallpapers",
                isIconShown = true,
            )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(White50)
                    .padding(innerPadding),
            ) {
                if (isLoading.value) {
                    // Loading Indicator
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    // Content when data is loaded
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(16.dp)
                    ) {
                        val horizontalImages = wallpapersState.value.features
                        val verticalImages = wallpapersState.value.top

                        // Title for Horizontal Images
                        Text(
                            text = "Features",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Black
                            ),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        // Horizontal Image Scrolling using LazyRow
                        LazyRow {
                            items(horizontalImages.size) { index ->
                                Box(
                                    modifier = Modifier
                                        .padding(end = 8.dp)
                                ) {
                                    AsyncImage(
                                        model = horizontalImages[index].imageUrl,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(210.dp)
                                            .clickable {
                                                navigateToImages(horizontalImages[index].imageUrl)
                                            }
                                        )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Title for Vertical Images (styled same as Features)
                        Text(
                            text = "Top",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Black
                            ),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        // Vertical Grid with 3 Columns
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier.height(600.dp)
                        ) {
                            items(verticalImages.size) { index ->
                                Box(
                                    modifier = Modifier
                                ) {
                                    AsyncImage(
                                        model = verticalImages[index].imageUrl,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(4.dp)
                                            .clickable {
                                                navigateToImages(verticalImages[index].imageUrl)
                                            }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        },
    )
}