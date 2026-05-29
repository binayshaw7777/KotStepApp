package com.binayshaw7777.kotstepapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.binayshaw7777.kotstepapp.presentation.ui.theme.KotStepAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val events = listOf<Event>(
            Event("Event 1", "Subtitle 1", "2023-10-01", "Flag 1"),
            Event("Event 2", "Subtitle 2", "2023-10-02", "Flag 2"),
            Event("Event 3", "Subtitle 3", "2023-10-03", "Flag 3"),
            Event("Event 4", "Subtitle 4", "2023-10-04", "Flag 4"),
            Event("Event 5", "Subtitle 5", "2023-10-05", "Flag 5"),
            Event("Event 6", "Subtitle 6", "2023-10-06", "Flag 6"),
        )

        setContent {
            KotStepAppTheme {
//                AppNavHost(navController = rememberNavController())

                Timeline(events)

            }
        }
    }
}

@Composable
fun TimelineItem(
    title: String,
    subtitle: String,
    date: String,
    flag: String,
    isLeftAligned: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if (isLeftAligned) {
            TimelineCard(title, subtitle)
            TimelineLineWithFlag(flag, date)
            Spacer(modifier = Modifier.weight(1f))
        } else {
            Spacer(modifier = Modifier.weight(1f))
            TimelineLineWithFlag(flag, date)
            TimelineCard(title, subtitle)
        }
    }
}

@Composable
fun TimelineCard(title: String, subtitle: String) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(Modifier.padding(12.dp)) {
            Text(title, fontWeight = FontWeight.Bold)
            Text(subtitle, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun TimelineLineWithFlag(flag: String, date: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .width(2.dp)
                .height(24.dp)
                .background(Color.LightGray)
        )
        Box(
            modifier = Modifier
                .size(12.dp)
                .background(Color(0xFF3F51B5), CircleShape)
        )
        Text(flag, modifier = Modifier.padding(top = 4.dp))
        Text(date, style = MaterialTheme.typography.bodySmall)
        Box(
            modifier = Modifier
                .width(2.dp)
                .height(24.dp)
                .background(Color.LightGray)
        )
    }
}

@Composable
fun Timeline(events: List<Event>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F6FA))
            .padding(horizontal = 16.dp)
    ) {
        itemsIndexed(events) { index, event ->
            TimelineItem(
                title = event.title,
                subtitle = event.subtitle,
                date = event.date,
                flag = event.flag,
                isLeftAligned = index % 2 == 0
            )
        }
    }
}

data class Event(
    val title: String,
    val subtitle: String,
    val date: String,
    val flag: String
)
