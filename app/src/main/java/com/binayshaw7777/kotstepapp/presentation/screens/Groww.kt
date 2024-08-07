package com.binayshaw7777.kotstepapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.binayshaw7777.kotstepapp.presentation.ui.theme.GROWW_BACKGROUND
import com.binayshaw7777.kotstepapp.presentation.ui.theme.GROWW_GREEN
import com.binayshaw7777.kotstepapp.util.Constants.NOTO_SANS_FONT_FAMILY
import com.binayshaw7777.kotstepapp.util.Constants.ROBOTO_FONT_FAMILY

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Groww(modifier: Modifier = Modifier, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Groww") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = GROWW_BACKGROUND)
            )
        }
    ) { paddingValues ->
        GrowwContent(modifier, paddingValues)
    }
}


@Composable
fun GrowwContent(modifier: Modifier = Modifier, paddingValues: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(GROWW_BACKGROUND)
            .then(modifier)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Check,
                tint = GROWW_BACKGROUND,
                contentDescription = null,
                modifier = Modifier
                    .size(28.dp)
                    .drawBehind {
                        drawCircle(
                            color = GROWW_GREEN,
                            radius = this.size.minDimension / 2
                        )
                    }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "₹100.00", style = TextStyle(
                    fontFamily = NOTO_SANS_FONT_FAMILY,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )

            Text(
                text = "New SIP   ∙   Completed", style = TextStyle(
                    fontFamily = NOTO_SANS_FONT_FAMILY,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = Color.LightGray
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Text(
                    text = "HDFC Mid Cap Opportunities Direct Plan  Growth", style = TextStyle(
                        fontFamily = ROBOTO_FONT_FAMILY,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = Color.LightGray
                    )
                )

                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        HorizontalDivider(color = Color.DarkGray, modifier = Modifier.padding(vertical = 24.dp))
    }
}