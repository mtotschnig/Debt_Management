package com.example.dept_management

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable

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
        viewModel.debts.value?.let {
            Screen(
                debts = it,
                onAddDebt = viewModel::addDebt,
                onClose = viewModel::addIsClosed,
                onRemoveDebt = viewModel::removeDebt,
                addClicked = viewModel.addButtonIsClicked,
                onAddClicked = viewModel::addIsClicked,
                currentlyEditing = viewModel.currentEditDebt,
                onEditDebt = viewModel::onEditDebt,
                onStartEdit = viewModel::onDebtSelected,
                onEditClose = viewModel::onEditClose
            )
        }
    }

}