package com.example.dept_management

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    var userRepository: MockUserRepository = MockUserRepository()
    var deptRepository: MockDeptRepository = MockDeptRepository()

    private var _users = MutableLiveData(userRepository.getContacts())
    val users:LiveData<List<Contact>> = _users

    var debts by mutableStateOf(deptRepository.getDepts())

    fun addDept(debt: Debt) {
        debts += debt
    }

    fun removeDept(debt: Debt) {
        debts = debts.toMutableList().also { it.remove(debt) }
    }
}