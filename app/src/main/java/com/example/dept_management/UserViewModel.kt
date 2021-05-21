package com.example.dept_management

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    // var userRepository: MockUserRepository = MockUserRepository()
    var debtRepository: DebtRepository = MockDebtRepository()

    /*
    private var _users = MutableLiveData(userRepository.getContacts())
    val users:LiveData<List<Contact>> = _users
     */

    var debts: LiveData<List<Debt>> = debtRepository.getDebts()

    var addButtonIsClicked by mutableStateOf(false)

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