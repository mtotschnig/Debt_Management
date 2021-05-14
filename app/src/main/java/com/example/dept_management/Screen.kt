package com.example.dept_management

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dept_management.ui.theme.Dept_ManagementTheme


@Composable
fun Screen (
    debts: List<Debt>,
    onAddDebt: (Debt) -> Unit,
    onRemoveDebt: (Debt) -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        Headline()
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(top = 8.dp)
        ) {
            items(items = debts) { Debt ->
                Row(
                    debt = Debt,
                    modifier = Modifier.fillMaxWidth(),
                    onItemClicked = onRemoveDebt
                )
            }
        }
        Button(
            onClick = { onAddDebt(randomDept()) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add Debt")
        }
    }
}

@Composable
fun Headline() {
    Text(
        text = "Debt Summary",
        style = MaterialTheme.typography.h5,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun Row (
    debt: Debt,
    onItemClicked: (Debt) -> Unit,
    modifier: Modifier
) {
    Row (
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onItemClicked(debt) },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.Done,
            contentDescription = null
        )
        Debt(
            debt = debt,
            modifier = modifier.padding(16.dp)
        )
    }
}

@Composable
fun DebtFormular(
    onAddDebt: (Debt) -> Unit
) {
    val (name, setName) = remember { mutableStateOf(" ") }
}

@Composable
fun Debt(
    debt: Debt,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(text = "Total Amount paid ${debt.paid}€ of ${debt.total} from  ${debt.contact.name}")
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Dept_ManagementTheme {
    }
}