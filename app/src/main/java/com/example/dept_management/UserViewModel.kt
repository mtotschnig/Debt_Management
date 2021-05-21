package com.example.dept_management

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    var debtRepository: DebtRepository = MockDebtRepository()

    var debts: LiveData<List<Debt>> = debtRepository.getDebts()

    var addButtonIsClicked = false

    var currentEditPosition = -1

    val currentEditDebt: Debt?
        get() = debtRepository.getDebt(currentEditPosition)

    fun addDebt(debt: Debt) {
        debtRepository.addDebt(debt)
        addButtonIsClicked = false
    }

    fun removeDebt(debt: Debt) {
        debtRepository.removeDebt(debt)
    }

    fun addIsClicked() {
        addButtonIsClicked = true
    }

    fun addIsClosed() {
        addButtonIsClicked = false
    }

    fun onDebtSelected (debt: Debt) {
        currentEditPosition = debtRepository.getIndex(debt)!!
    }

    fun onEditDebt(debt: Debt) {
        debtRepository.editDebt(debt,currentEditPosition)
        currentEditPosition = -1
    }

    fun onEditClose () {
        currentEditPosition = -1
    }
}