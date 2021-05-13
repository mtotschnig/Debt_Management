package com.example.dept_management

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dept_management.ui.theme.Dept_ManagementTheme


@Composable
fun Screen (
    depts: List<Dept>,
    onAddDept: (Dept) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(top = 8.dp),
    ) {
        items(items = depts) { Dept ->
            Row(
                dept = Dept,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
    Button(onClick = { onAddDept(randomDept()) }) {
        
    }
}


@Composable
fun Row (
    dept: Dept,
    modifier: Modifier
) {
    Row (
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.Done,
            contentDescription = null
        )
        Dept(
            dept = dept,
            modifier = modifier.padding(16.dp)
        )
    }
}

@Composable
fun Dept(
    dept: Dept,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(text = "Total Amount paid ${dept.paid}€ of ${dept.total} from  ${dept.contact.name}")
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Dept_ManagementTheme {
    }
}