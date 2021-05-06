package com.example.dept_management

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    var userRepository: MockUserRepository = MockUserRepository()

    private var _users = MutableLiveData(userRepository.getUsers())
    val users:LiveData<List<User>> = _users

    private var _depts = MutableLiveData(listOf<Dept>())
    val depts:LiveData<List<Dept>> = _depts


}