package com.example.mycomposeapp.feature.home.navigaiton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mycomposeapp.ui.theme.component.ProductCard


@Composable
internal fun HomeScreenRoute(
    modifier: Modifier = Modifier, viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetail:(Int)->Unit
) {
    val homeUiState by viewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(modifier = modifier, homeUiState,navigateToDetail)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeUiState: HomeUiState, navigateToDetail:(Int)->Unit) {
    Scaffold(modifier = modifier,
        topBar = {
        TopAppBar(title = { Text(text = "Home") })
    }) {
        Content(modifier = Modifier.padding(it), homeUiState = homeUiState
        ,navigateToDetail=navigateToDetail)
    }

}

@Composable
private fun Content(modifier: Modifier, homeUiState: HomeUiState, navigateToDetail:(Int)->Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = modifier.fillMaxSize().padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LazyColumn(modifier = Modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(homeUiState.products, key = { product ->

                    product.id.toString()
                }) {
                   ProductCard(productItem = it,
                       onProductDetailClicked ={navigateToDetail.invoke(it)} )
                }
            }
        }
    }
}