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

    var depts by mutableStateOf(deptRepository.getDepts())

    fun addDept(dept: Dept) {
        depts += dept
    }
}