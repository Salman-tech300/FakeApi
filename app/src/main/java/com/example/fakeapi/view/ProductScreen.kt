package com.example.fakeapi.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fakeapi.viewmodel.ProductViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(viewModel: ProductViewModel = viewModel()) {
    val products by viewModel.products.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Fake Store Products") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.White
                )
              )
        }    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            if (products == null) {
                Box (
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn {
                    items(products!!) { product ->
                        ProductItem(product)
                    }
                }
            }
        }
    }
}
