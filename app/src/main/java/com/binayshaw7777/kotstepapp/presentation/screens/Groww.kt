package com.binayshaw7777.kotstepapp.presentation.screens

import android.util.Log
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
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.binayshaw7777.kotstep.model.LineDefault
import com.binayshaw7777.kotstep.model.StepDefaults
import com.binayshaw7777.kotstep.model.StepStyle
import com.binayshaw7777.kotstep.model.numberedVerticalWithLabel
import com.binayshaw7777.kotstep.ui.vertical.VerticalStepper
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

            Spacer(modifier = Modifier.height(8.dp))

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
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            ) {
                Text(
                    text = "HDFC Mid Cap Opportunities Direct Plan  Growth", style = TextStyle(
                        fontFamily = ROBOTO_FONT_FAMILY,
                        fontWeight = FontWeight.SemiBold,
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

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            GrowwSideCard(
                modifier = Modifier.weight(1f),
                title = "Completed on",
                text = "02 Aug '24"
            )
            VerticalDivider(
                modifier = Modifier
                    .height(48.dp)
                    .padding(horizontal = 16.dp)
            )
            GrowwSideCard(modifier = Modifier.weight(1f), title = "NAV Date", text = "01 Aug '24")
        }

        HorizontalDivider(color = Color.DarkGray, modifier = Modifier.padding(vertical = 24.dp))

        Text(
            text = "Status",
            style = TextStyle(
                fontFamily = ROBOTO_FONT_FAMILY,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        VerticalStepper(
            style = numberedVerticalWithLabel(
                totalSteps = 3,
                currentStep = 3,
                trailingLabels = listOf(
                    {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                "Payment confirmed",
                                style = TextStyle(
                                    fontFamily = ROBOTO_FONT_FAMILY,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Color.White
                                ),
                            )
                            Text(
                                "02 Aug, '24, 09:00 AM",
                                style = TextStyle(
                                    fontFamily = ROBOTO_FONT_FAMILY,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                ),
                            )
                        }
                    },
                    {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                "Order approved by exchange",
                                style = TextStyle(
                                    fontFamily = ROBOTO_FONT_FAMILY,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Color.White
                                ),
                            )
                            Text(
                                "03 Aug, '24, 09:05 AM",
                                style = TextStyle(
                                    fontFamily = ROBOTO_FONT_FAMILY,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                ),
                            )
                        }
                    },
                    {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                "Units allocated",
                                style = TextStyle(
                                    fontFamily = ROBOTO_FONT_FAMILY,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Color.White
                                ),
                            )
                            Text(
                                "04 Aug, '24, 10:15 AM",
                                style = TextStyle(
                                    fontFamily = ROBOTO_FONT_FAMILY,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                ),
                            )
                        }
                    }
                ),
                stepStyle = StepStyle(
                    colors = StepDefaults(
                        doneContentColor = GROWW_BACKGROUND,
                        doneContainerColor = GROWW_GREEN,
                        doneLineColor = Color.DarkGray
                    ),
                    lineStyle = LineDefault(
                        lineThickness = 1.dp,
                        lineSize = 36.dp,
                        linePaddingTop = 5.dp,
                        linePaddingBottom = 5.dp
                    ),
                    stepSize = 18.dp
                )
            ),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Log.d("GROWW", "Step clicked was: $it")
        }

        HorizontalDivider(color = Color.DarkGray, modifier = Modifier.padding(vertical = 24.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Details", style = TextStyle(
                    fontFamily = ROBOTO_FONT_FAMILY,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                tint = Color.White,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }

        HorizontalDivider(color = Color.DarkGray, modifier = Modifier.padding(vertical = 24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Help,
                tint = Color.LightGray,
                contentDescription = null,
            )
            Text(
                text = "Need Help?", style = TextStyle(
                    fontFamily = ROBOTO_FONT_FAMILY,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.White
                ),
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                tint = Color.White,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun GrowwSideCard(
    modifier: Modifier = Modifier,
    title: String,
    text: String
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .then(modifier)
    ) {
        Text(
            text = title, style = TextStyle(
                fontFamily = ROBOTO_FONT_FAMILY,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = Color.LightGray
            )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = text, style = TextStyle(
                    fontFamily = ROBOTO_FONT_FAMILY,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.White
                )
            )
            Icon(
                imageVector = Icons.Outlined.Info,
                tint = Color.White,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}