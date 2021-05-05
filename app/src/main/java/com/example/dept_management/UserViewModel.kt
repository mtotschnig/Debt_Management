package com.example.dept_management

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private var _Users = MutableLiveData(listOf<User>())
    val Users:LiveData<List<User>> = _Users

    private var _Depts = MutableLiveData(listOf<Dept>())
    val Depts:LiveData<List<Dept>> = _Depts


}