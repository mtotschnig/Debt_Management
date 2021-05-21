package com.example.dept_management

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

class MainActivity : ComponentActivity() {

    val userViewModel by viewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ActivityScreen(viewModel = userViewModel)
        }
    }

    @Composable
    fun ActivityScreen(viewModel: UserViewModel) {
        val debts: List<Debt> by viewModel.debts.observeAsState(emptyList())
        Screen(
            debts = debts,
            onAddDebt = viewModel::addDebt,
            onRemoveDebt = viewModel::removeDebt,
            currentlyEditing = viewModel.currentEditDebt,
            onEditDebt = viewModel::onEditDebt,
            onStartEdit = viewModel::onDebtSelected,
            onEditClose = viewModel::onEditClose
        )
    }

}
