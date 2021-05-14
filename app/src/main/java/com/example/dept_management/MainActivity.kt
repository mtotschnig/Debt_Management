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
        Screen(
            debts = viewModel.debts,
            onAddDebt = viewModel::addDept,
            onRemoveDebt = viewModel::removeDept
        )
    }

}