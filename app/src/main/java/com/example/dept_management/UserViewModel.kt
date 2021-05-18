package com.example.dept_management

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    // var userRepository: MockUserRepository = MockUserRepository()
    var debtRepository: MockDebtRepository = MockDebtRepository()

    /*
    private var _users = MutableLiveData(userRepository.getContacts())
    val users:LiveData<List<Contact>> = _users
     */

    var debts by mutableStateOf(debtRepository.getDebts())
    var addButtonIsClicked by mutableStateOf(false)
    var editButtonIsClicked by mutableStateOf(false)

    fun addDebt(debt: Debt) {
        debts += debt
        addButtonIsClicked = false
    }

    fun removeDebt(debt: Debt) {
        debts = debts.toMutableList().also { it.remove(debt) }
    }


    fun addIsClicked() {
        addButtonIsClicked = true
    }

    fun addIsClosed() {
        addButtonIsClicked = false
    }
}