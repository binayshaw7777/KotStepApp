package com.binayshaw7777.kotstepapp.presentation.screens

import android.util.Log
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.binayshaw7777.kotstep.model.LineDefault
import com.binayshaw7777.kotstep.model.LineType
import com.binayshaw7777.kotstep.model.StepDefaults
import com.binayshaw7777.kotstep.model.StepStyle
import com.binayshaw7777.kotstep.model.tabVerticalWithLabel
import com.binayshaw7777.kotstep.ui.vertical.VerticalStepper
import com.binayshaw7777.kotstepapp.R
import com.binayshaw7777.kotstepapp.presentation.ui.theme.AMAZON_GREEN
import com.binayshaw7777.kotstepapp.presentation.ui.theme.AMAZON_TEXT_PRIMARY_GREEN
import com.binayshaw7777.kotstepapp.presentation.ui.theme.AMAZON_TEXT_SECONDARY_GREEN
import com.binayshaw7777.kotstepapp.presentation.ui.theme.GROWW_BACKGROUND
import com.binayshaw7777.kotstepapp.presentation.ui.theme.GROWW_GREEN
import com.binayshaw7777.kotstepapp.util.Constants.ROBOTO_FONT_FAMILY

@Composable
fun Amazon(modifier: Modifier = Modifier, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            AmazonTopAppBar {
                onBack()
            }
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
fun AmazonTopAppBar(onBack: () -> Unit) {
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
                    .padding(end = 16.dp, top = 16.dp, bottom = 16.dp)
            ) {
                IconButton(
                    onClick = { onBack() }
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
            .padding(vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Arriving today by 9 PM",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00796B) // Teal-like color
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.macbook_image),
                contentDescription = null,
                modifier = Modifier.width(64.dp),
                contentScale = ContentScale.Fit
            )
        }

        HorizontalDivider(
            modifier = Modifier.padding(top = 20.dp, bottom = 30.dp),
            color = Color.LightGray
        )

        OrderTrackingStatus()

        HorizontalDivider(modifier = Modifier.padding(vertical = 20.dp), color = Color.LightGray, thickness = 4.dp)

        DeliveryDetails()
    }
}

@Composable
fun OrderTrackingStatus() {
    VerticalStepper(
        style = tabVerticalWithLabel(
            totalSteps = 4,
            currentStep = 2.6f,
            trailingLabels = listOf(
                {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            "Ordered Sunday, 20 March",
                            style = TextStyle(
                                fontFamily = ROBOTO_FONT_FAMILY,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                color = AMAZON_TEXT_PRIMARY_GREEN
                            )
                        )
                    }
                },
                {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            "Shipped Monday, 21 March",
                            style = TextStyle(
                                fontFamily = ROBOTO_FONT_FAMILY,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                color = AMAZON_TEXT_PRIMARY_GREEN
                            )
                        )
                    }
                },
                {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            "Out for delivery",
                            style = TextStyle(
                                fontFamily = ROBOTO_FONT_FAMILY,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = AMAZON_TEXT_PRIMARY_GREEN
                            ),
                        )
                        Text(
                            "See all updates",
                            style = TextStyle(
                                fontFamily = ROBOTO_FONT_FAMILY,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                color = AMAZON_TEXT_SECONDARY_GREEN
                            ),
                        )
                    }
                },
                {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            "Arriving today by 9 PM",
                            style = TextStyle(
                                fontFamily = ROBOTO_FONT_FAMILY,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                color = Color.LightGray
                            )
                        )
                    }
                }
            ),
            stepStyle = StepStyle(
                colors = StepDefaults(
                    doneContentColor = AMAZON_GREEN,
                    doneContainerColor = AMAZON_GREEN,
                    currentContainerColor = AMAZON_GREEN,
                    doneLineColor = AMAZON_GREEN,
                    checkMarkColor = Color.White,
                    currentLineColor = AMAZON_GREEN,
                    todoLineColor = Color.LightGray
                ),
                lineStyle = LineDefault(
                    lineThickness = 4.dp,
                    lineSize = 48.dp,
                    todoLineTrackType = LineType.DASHED,
                    todoLineProgressType = LineType.DASHED,
                    currentLineTrackType = LineType.DASHED,
                    currentLineProgressType = LineType.SOLID
                ),
                stepSize = 28.dp,
                showStrokeOnCurrent = true,
                stepShape = RectangleShape
            )
        ),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Log.d("GROWW", "Step clicked was: $it")
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
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Delivery by Amazon",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = ROBOTO_FONT_FAMILY,
            color = AMAZON_TEXT_PRIMARY_GREEN
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Tracking ID: 277006711517",
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            fontFamily = ROBOTO_FONT_FAMILY,
            color = AMAZON_TEXT_PRIMARY_GREEN
        )
    }

    HorizontalDivider(modifier = Modifier.padding(vertical = 20.dp), color = Color.LightGray, thickness = 4.dp)

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Shipping Address",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = ROBOTO_FONT_FAMILY,
            color = AMAZON_TEXT_PRIMARY_GREEN
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "167, OK, Some random address, c'mon I'm not gonna reveal my address lmao",
            fontSize = 14.sp,
            fontFamily = ROBOTO_FONT_FAMILY,
            color = AMAZON_TEXT_PRIMARY_GREEN
        )
    }
}
