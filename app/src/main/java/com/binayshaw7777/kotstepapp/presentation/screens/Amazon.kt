package com.binayshaw7777.kotstepapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.DocumentScanner
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.binayshaw7777.kotstepapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Amazon(modifier: Modifier = Modifier, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            AmazonTopAppBar()
//            TopAppBar(
//                title = { Text(text = "Amazon") },
//                navigationIcon = {
//                    IconButton(onClick = { onBack() }) {
//                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
//                    }
//                }
//            )
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween,
//            ) {
//                IconButton(onClick = { onBack() }) {
//                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
//                }
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Icon(Icons.Filled.Search, contentDescription = "Search")
//                    Text(text = "Search Amazon.in")
//                }
//            }
        }
    ) { paddingValues ->
        AmazonContent(modifier = modifier, paddingValues = paddingValues)
    }
}

@Composable
fun AmazonContent(modifier: Modifier = Modifier, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.White)
            .then(modifier)
    ) {
        AmazonOrderTrackingUI()
    }
}

@Composable
fun AmazonTopAppBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF84D8E3),
                        Color(0xFF8BDCDE),
                        Color(0xFF93E0DA),
                        Color(0xFF9CE3D3),
                        Color(0xFFA5E7CC)
                    ),
                    start = Offset(221.25f, 108.5f),
                    end = Offset(663.75f, 108.5f)
                )
            )
    ) {
        Column {
            Spacer(modifier = Modifier.statusBarsPadding())
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Icon",
                        tint = Color.Black
                    )
                }
                TextField(
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    ),
                    maxLines = 1,
                    modifier = Modifier
                        .weight(1f)
                        .padding()
                        .height(48.dp)
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(5.dp)),
                    value = "",
                    placeholder = {
                        Text(
                            text = "Search Amazon.in",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                        )
                    },
                    onValueChange = {},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon",
                            tint = Color.DarkGray
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_scan_amazon),
                            contentDescription = "Scan Icon",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = Color.White,
                        unfocusedSupportingTextColor = Color.DarkGray,
                        focusedTextColor = Color.DarkGray,
                        unfocusedTextColor = Color.DarkGray,
                        focusedSupportingTextColor = Color.DarkGray
                    )
                )
                IconButton(
                    onClick = { /* Handle back action */ }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_mic_amazon),
                        contentDescription = "Mic Icon",
                        tint = Color.DarkGray,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AmazonOrderTrackingUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row {
            Text(
                text = "Arriving today by 9 PM",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00796B) // Teal-like color
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.macbook_image),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        OrderTrackingStatus()
        Spacer(modifier = Modifier.height(24.dp))
        DeliveryDetails()
    }
}

@Composable
fun OrderTrackingStatus() {
    Column {
        TrackingStep(
            title = "Ordered Sunday, 20 February",
            isCompleted = true
        )
        TrackingStep(
            title = "Shipped Monday, 21 February",
            isCompleted = true
        )
        TrackingStep(
            title = "Out for delivery",
            isCompleted = true,
            showUpdates = true
        )
        TrackingStep(
            title = "Arriving today",
            isCompleted = false
        )
    }
}

@Composable
fun TrackingStep(
    title: String,
    isCompleted: Boolean,
    showUpdates: Boolean = false
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 8.dp)
    ) {
        // Circle indicator
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(if (isCompleted) Color(0xFF00796B) else Color.LightGray)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = title,
                fontSize = 16.sp,
                color = if (isCompleted) Color.Black else Color.Gray
            )
            if (showUpdates) {
                Text(
                    text = "See all updates",
                    fontSize = 14.sp,
                    color = Color(0xFF00796B)
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun DeliveryDetails() {
    Column {
        Text(
            text = "Delivery by Amazon",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Tracking ID: 277006711517",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Shipping Address",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Sheenam\nB-16/86/1 GHALORI GATE PATIALA,\nPatiala Punjab 147001",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}
