package com.binayshaw7777.kotstepapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.binayshaw7777.kotstepapp.presentation.navigation.NavigationScreen

@Composable
fun Home(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
                .then(modifier)
        ) {
            LazyColumn {
                items(NavigationScreen.entries) { screen ->
                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.05f))
                            .clickable {
                                onClick(screen.name)
                            }
                    ) {
                        Text(
                            text = screen.name.lowercase()
                                .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it. toString() },
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}