package com.example.dept_management

interface UserRepository {
    fun getUsers(): List<User>
}

class MockUserRepository : UserRepository{
    override fun getUsers(): List<User> {
        return listOf(
            User(name ="Max",budget = 1000),
            User(name = "Fabienne", budget = 5000),
            User(name = "Till", budget = 2000)
            )
    }
}