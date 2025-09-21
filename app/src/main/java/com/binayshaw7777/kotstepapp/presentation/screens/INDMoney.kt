package com.binayshaw7777.kotstepapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.binayshaw7777.kotstep.v3.KotStep
import com.binayshaw7777.kotstep.v3.util.ExperimentalKotStep
import com.binayshaw7777.kotstepapp.R
import com.binayshaw7777.kotstepapp.presentation.ui.theme.AtypFontFamily
import com.binayshaw7777.kotstepapp.util.Util.StepLabel
import com.binayshaw7777.kotstepapp.util.Util.getIndMoneyStepperSteps
import com.binayshaw7777.kotstepapp.util.Util.getIndMoneyStepperStyle
import com.binayshaw7777.kotstepapp.util.Util.openLink

@Composable
fun INDMoney(
    onBackPress: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF0F1314))
            .verticalScroll(rememberScrollState())
    ) {
        SipRegistrationCard(onBackPress = onBackPress)
        StepperContent()
        SipDetailsCard()
        HelpCard()
    }
}

@Composable
fun HelpCard() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Still haven't checked KotStep?",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF4597F3),
            modifier = Modifier.padding(bottom = 4.dp).clickable {
                context.openLink()
            }
        )
        Text(
            text = "You can raise a issues and share feedbacks. I'll try to reach out to you asap within 24 business hrs.",
            fontSize = 10.sp,
            color = Color(0xFF979CA2),
            textAlign = TextAlign.Center,
            lineHeight = TextUnit(14f, TextUnitType.Sp),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(48.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    context.openLink()
                },
                modifier = Modifier
                    .weight(1f),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF199A61))
            ) {
                Text(text = "Manage SIP", color = Color.White, fontSize = 14.sp)
            }
            Button(
                onClick = {
                    context.openLink()
                },
                modifier = Modifier
                    .weight(1f),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF199A61))
            ) {
                Text(text = "Invest More", color = Color.White, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun SipDetailsCard() {
    Box(contentAlignment = Alignment.TopCenter) {
        Card(
            modifier = Modifier
                .padding(top = 48.dp)
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1A1D22)
            )
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Jetpack Composes. KotStep Direct Plan Growth Fund",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 28.sp,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))
                KeyValuRow(label = "Order ID", value = "12345678")
                Spacer(modifier = Modifier.height(2.dp))
                HorizontalDivider(color = Color(0xFF252A30))
                Spacer(modifier = Modifier.height(8.dp))
                KeyValuRow(label = "SIP Amount", value = "₹5,000")
                Spacer(modifier = Modifier.height(2.dp))
                HorizontalDivider(color = Color(0xFF252A30))
                Spacer(modifier = Modifier.height(8.dp))
                KeyValuRow(label = "SIP Date", value = "03 Oct 2025")
                Spacer(modifier = Modifier.height(2.dp))
                HorizontalDivider(color = Color(0xFF252A30))
                Spacer(modifier = Modifier.height(8.dp))
                KeyValuRow(label = "Frequency", value = "MONTHLY")
                Spacer(modifier = Modifier.height(2.dp))
                HorizontalDivider(color = Color(0xFF252A30))

                Spacer(modifier = Modifier.height(24.dp))

                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Expand",
                    tint = Color(0xFFBDBDBD),
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.jetpack_compose_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(4.dp, Color(0xFF424242), CircleShape)
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun KeyValuRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color(0xFF979CA2)
        )
        Text(
            text = value,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}

@OptIn(ExperimentalKotStep::class)
@Composable
private fun StepperContent() {
    Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp)) {

        val stepperStyle = remember { mutableStateOf(getIndMoneyStepperStyle()) }
        val stepItems = remember { mutableStateOf(getIndMoneyStepperSteps()) }
        var stepValue by remember { mutableIntStateOf(1) }

        Text(
            text = "ORDER STATUS (Order Id: 1234567890)",
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF979CA2),
        )

        Spacer(modifier = Modifier.height(16.dp))

        KotStep(
            modifier = Modifier.fillMaxWidth(),
            currentStep = { stepValue.toFloat() },
            style = stepperStyle.value
        ) {
            stepItems.value.forEach { item ->
                step(
                    title = item.number,
                    label = {
                        StepLabel(item) {
                            stepValue = (stepValue + 1) % 6
                        }
                    },
                    onClick = {
                        stepValue = (stepValue + 1) % 6
                    }
                )
            }
        }
    }
}

@Composable
fun SipRegistrationCard(onBackPress: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF3BB880)
        )
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier.padding(top = 36.dp).background(Color(0xFF252A30), CircleShape)
                    .padding(3.dp)
                    .clickable { onBackPress() }
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close",
                    tint = Color(0xFF838A90),
                    modifier = Modifier.size(14.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)) {
                Text(
                    text = "SIP registered successfully",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 28.sp,
                    letterSpacing = 0.75.sp,
                    fontFamily = AtypFontFamily,
                    color = Color.White,
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "1st installment due on 03 Oct 2025",
                    fontSize = 14.sp,
                    color = Color(0xFFC3EAD8),
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(R.drawable.jetpack_compose_logo),
                        contentDescription = "Aditya Birla Sun Life Logo",
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(8.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "Jetpack Compose.\nKotStep Direct Plan Growth Fund",
                        fontSize = 14.sp,
                        lineHeight = TextUnit(value = 16f, type = TextUnitType.Sp),
                        color = Color.White,
                        fontFamily = AtypFontFamily,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "View Details",
                        fontSize = 11.sp,
                        color = Color.White,
                        textDecoration = TextDecoration.Underline,
                        fontFamily = AtypFontFamily
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = "₹5,000/monthly",
                    fontSize = 36.sp,
                    fontFamily = AtypFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}