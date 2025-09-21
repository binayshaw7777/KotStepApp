package com.binayshaw7777.kotstepapp.util

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.binayshaw7777.kotstep.v3.model.step.StepLayoutStyle
import com.binayshaw7777.kotstep.v3.model.style.BorderStyle
import com.binayshaw7777.kotstep.v3.model.style.KotStepStyle
import com.binayshaw7777.kotstep.v3.model.style.LineStyle
import com.binayshaw7777.kotstep.v3.model.style.LineStyles
import com.binayshaw7777.kotstep.v3.model.style.StepStyle
import com.binayshaw7777.kotstep.v3.model.style.StepStyles
import com.binayshaw7777.kotstep.v3.util.ExperimentalKotStep

object Util {

    fun Context.openLink(url: String = "https://github.com/binayshaw7777/KotStep") {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = url.toUri()
        startActivity(intent)
    }

    @Composable
    fun StepLabel(item: StepItem, onClick: () -> Unit = {}) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable { onClick() }
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = item.title,
                    fontSize = 12.sp,
                    color = Color(0xFF979CA2),
                    style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
                )
                Text(
                    text = item.subtitle,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
                )
            }

            item.status?.let {
                Spacer(modifier = Modifier.weight(1f))
                StatusBadge(it)
            }
        }
    }

    @Composable
    fun StatusBadge(text: String) {
        Box(
            modifier = Modifier
                .background(color = Color(0xFF152C22), shape = RoundedCornerShape(4.dp))
                .padding(horizontal = 4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = Color(0xFF32AB80), fontSize = 11.sp)
        }
    }

    data class StepItem(
        val number: String,
        val title: String,
        val subtitle: String,
        val numberColor: Color,
        val status: String? = null
    )

    fun getIndMoneyStepperSteps(): List<StepItem> {
        return listOf(
            StepItem(
                number = "1",
                title = "SIP registration",
                subtitle = "18 Sep 2025 09:59 AM",
                numberColor = Color.White,
                status = "Success"
            ),
            StepItem(
                number = "2",
                title = "1st installment due",
                subtitle = "03 Oct 2025",
                numberColor = Color(0xFF838A90)
            ),
            StepItem(
                number = "3",
                title = "Amount auto-debited from your a/c by BSE",
                subtitle = "03 Oct 2025\nBank a/c: Compose Bank xxxx1234",
                numberColor = Color(0xFFBDBDBD)
            ),
            StepItem(
                number = "4",
                title = "Auto-payment confirmation received from BSE",
                subtitle = "03 Oct 2025",
                numberColor = Color(0xFFBDBDBD)
            ),
            StepItem(
                number = "5",
                title = "Units to be allocated by mutual fund",
                subtitle = "07 Oct 2025\nEst NAV Date: 03 Oct 2025",
                numberColor = Color(0xFFBDBDBD)
            )
        )
    }

    @OptIn(ExperimentalKotStep::class)
    fun getIndMoneyStepperStyle(): KotStepStyle {
        return KotStepStyle(
            stepLayoutStyle = StepLayoutStyle.Vertical,
            showCheckMarkOnDone = false,
            ignoreCurrentState = false,
            stepStyle = StepStyles.default().copy(
                onTodo = StepStyle.defaultTodo().copy(
                    stepSize = 20.dp,
                    stepColor = Color(0xFFF5F5F7),
                    textStyle = TextStyle(color = Color(0xFFBDBDBD), platformStyle = PlatformTextStyle(includeFontPadding = false), fontSize = 11.sp),
                    borderStyle = BorderStyle(width = 2.dp, color = Color(0xFFBDBDBD))
                ),
                onCurrent = StepStyle.defaultTodo().copy(
                    stepColor = Color(0xFF252A30),
                    stepSize = 24.dp,
                    textStyle = TextStyle(color = Color(0xFF838A90), platformStyle = PlatformTextStyle(includeFontPadding = false), fontSize = 11.sp),
                    borderStyle = BorderStyle(width = 1.dp, color = Color(0xFF838A90))
                ),
                onDone = StepStyle.defaultTodo().copy(
                    stepSize = 20.dp,
                    textStyle = TextStyle(color = Color.White, platformStyle = PlatformTextStyle(includeFontPadding = false), fontSize = 11.sp),
                    stepColor = Color(0xFF1AB780)
                )
            ),
            lineStyle = LineStyles.default().copy(
                onTodo = LineStyle.defaultTodo().copy(
                    lineThickness = 2.dp,
                    lineLength = 24.dp,
                    linePadding = PaddingValues(4.dp),
                    lineColor = Color(0xFF767779),
                    progressColor = Color(0xFF767779)
                ),
                onCurrent = LineStyle.defaultCurrent().copy(
                    lineThickness = 2.dp,
                    lineLength = 24.dp,
                    linePadding = PaddingValues(4.dp),
                    lineColor = Color(0xFF767779),
                    progressColor = Color(0xFF767779),
                ),
                onDone = LineStyle.defaultDone().copy(
                    lineThickness = 2.dp,
                    lineLength = 24.dp,
                    linePadding = PaddingValues(4.dp),
                    lineColor = Color(0xFF767779),
                    progressColor = Color(0xFF767779)
                )
            )
        )
    }

}