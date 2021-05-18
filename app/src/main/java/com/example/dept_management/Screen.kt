package com.example.dept_management

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
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
    onClose: () -> Unit,
    onRemoveDebt: (Debt) -> Unit,
    addClicked: Boolean,
    onAddClicked: () -> Unit
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
                    onIconClicked = onRemoveDebt
                )
            }
        }
        if (addClicked) {
            DebtForm(onAddDebt, onClose)
        } else {
            Button(
                onClick = onAddClicked,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Add Debt")
            }
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
    onIconClicked: (Debt) -> Unit,
    modifier: Modifier
) {
    val (paid,setPaid) = remember {
        mutableStateOf("")
    }
    Row (
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.Done,
            contentDescription = null,
            modifier = Modifier.clickable { onIconClicked(debt) }
        )
        Debt(
            debt = debt,
            modifier = modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun DebtForm(
    onAddDebt: (Debt) -> Unit,
    onClose:() -> Unit
) {
    val (name, setName) = remember { mutableStateOf("") }
    val (paid, setPaid) = remember { mutableStateOf("") }
    val (total, setTotal) = remember { mutableStateOf("") }
    val submit = {
        if(total.toLongOrNull() == null || paid.toLongOrNull() == null) {
            //TODO Toast msg
        } else {
            onAddDebt(Debt(name, total.toLongOrNull(), paid.toLongOrNull()))
        }
    }
    val mod = Modifier
        .fillMaxWidth()
        .padding(8.dp)

    Column {
        InputField (modifier = mod, value = name, onValueChange = setName, label = "Name")
        InputField (modifier = mod, value = total, onValueChange = setTotal, label = "Total Debt")
        InputField (modifier = mod, value = paid, onValueChange = setPaid, label = "Paid Debt")
        Row(
           horizontalArrangement = Arrangement.SpaceEvenly,
           modifier = Modifier
               .fillMaxWidth(1f)
        ) {
           Button(
               modifier = Modifier
                   .fillMaxWidth()
                   .weight(1f),
               onClick = submit
           ) {
               Text(text = "Add")
           }
           Button(
               modifier = Modifier
                   .fillMaxWidth()
                   .weight(1f),
               onClick = onClose
           ) {
               Text(text = "Close")
           }
       }
    }
}

@Composable
fun InputField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        maxLines = 1,
        label = { Text(text = label)}
    )

}


@Composable
fun Debt(
    debt: Debt,
    modifier: Modifier
) {
        Text(
            text = "Total Amount paid ${debt.paid}€ of ${debt.total} from ${debt.name}",
            modifier = modifier
        )
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Dept_ManagementTheme {
    }
}