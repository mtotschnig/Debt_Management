package com.example.dept_management

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import com.example.dept_management.ui.theme.Dept_ManagementTheme


@Composable
fun Screen (
    debts: List<Debt>,
    onAddDebt: (Debt) -> Unit,
    onClose: () -> Unit,
    onRemoveDebt: (Debt) -> Unit,
    addClicked: Boolean,
    onAddClicked: () -> Unit,
    currentlyEditing: Debt?,
    onEditDebt: (Debt) -> Unit,
    onStartEdit: (Debt) -> Unit,
    onEditClose: () -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        Headline()
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(top = 8.dp)
        ) {
            items(items = debts) { Debt ->
                if(currentlyEditing?.id == Debt.id) {
                    EditField(
                        debt = Debt,
                        onAddEdit = onEditDebt,
                        onEditClose = onEditClose
                    )
                } else {
                    Row(
                        debt = Debt,
                        modifier = Modifier.fillMaxWidth(),
                        onIconClicked = onRemoveDebt,
                        onDebtClicked = onStartEdit
                    )
                }
            }
        }
        if (addClicked) {
            DebtForm(onAddDebt, onClose)
        } else {
            
            FloatingActionButton(
                onClick = onAddClicked,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(16.dp)
            ) {
                Text(text = "+")
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
    onDebtClicked: (Debt) -> Unit,
    modifier: Modifier
) {
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
                .clickable { onDebtClicked(debt) }
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
        TextField(modifier = mod,value = name, onValueChange = setName, label = {Text("Name")})
        TextField (modifier = mod, value = total, onValueChange = setTotal, label = {Text("Total Debt")})
        TextField (modifier = mod, value = paid, onValueChange = setPaid, label = {Text("Paid Debt")})
        Row(
           horizontalArrangement = Arrangement.SpaceEvenly,
           modifier = Modifier
               .fillMaxWidth(1f)
        ) {
           Button(
               modifier = mod
                   .weight(1f),
               onClick = submit
           ) {
               Text(text = "Add")
           }
           Button(
               modifier = mod
                   .weight(1f),
               onClick = onClose
           ) {
               Text(text = "Close")
           }
       }
    }
}

@Composable
fun EditField(
    debt: Debt,
    onAddEdit: (Debt) -> Unit,
    onEditClose: () -> Unit
) {
    val mod = Modifier
        .fillMaxWidth()
        .padding(4.dp)
    val (newPaid, setPaid) = remember { mutableStateOf("") }
    val (newTotal, setTotal) = remember { mutableStateOf("") }
    val submit = {
        if(newPaid.toLongOrNull() == null || newTotal.toLongOrNull() == null) {
            //TODO Toast msg
        } else {
            onAddEdit(debt.copy(total = newTotal.toLong() ,paid = newPaid.toLong()))
        }
    }
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .border(1.dp, Color.Gray)
    ) {
        Column(modifier = mod) {
            Text(
                text = "Name: ${debt.name}",
                modifier = mod,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
            OutlinedTextField(
                value = newTotal,
                onValueChange = setTotal,
                label = { Text(text = "New Total (${debt.total})")},
                modifier = mod
            )
            OutlinedTextField(
                value = newPaid,
                onValueChange = setPaid,
                label = { Text(text = "New Paid (${debt.paid})") },
                modifier = mod
            )
            Row(modifier = mod) {
                Button(
                    onClick = submit,
                    modifier = mod.weight(1f)
                ) {
                    Text(text = "Save Edit")
                }
                Button(
                    onClick = onEditClose,
                    modifier = mod.weight(1f)
                ) {
                    Text(text = "Close")
                }
            }
        }
    }
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