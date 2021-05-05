package com.example.dept_management

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dept_management.ui.theme.Dept_ManagementTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                SetHeadline()
                SetDept()
                SetDept()
                SetDept()
            }
        }
    }
}

@Composable
fun SetHeadline() {
    Box(
        modifier = Modifier
            .border(width = 4.dp, color = Gray, shape = RoundedCornerShape(16.dp))
    ) {
        Text(
            "Dept Summary",
            Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            style = typography.h6,
        )

        /*
    Text (
        text = "Dept Summary",
        textAlign = TextAlign.Right,
        modifier = Modifier.padding(36.dp)
    )
     */
    }
}


@Composable
fun SetDept(name: String = "Tom", paid: Long = 50, total: Long = 100){

    Row (modifier = Modifier.padding(12.dp)){
        Button(onClick = { /*TODO*/ }) {

        }
        Column(modifier = Modifier.padding(6.dp)) {
            Text(name)
            Text("$paid€ of $total€ paid")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Dept_ManagementTheme {
        SetHeadline()
        SetDept()
    }
}