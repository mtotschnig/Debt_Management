package com.example.dept_management

import java.time.LocalDate
import java.time.format.DateTimeFormatter

interface DeptRepository {
    fun getDepts(): List<Dept>
}

class MockDeptRepository : DeptRepository {

    var contactRepository: MockUserRepository = MockUserRepository()
    private var depts: List<Dept> = listOf(
        Dept("01-03-2021",1000,0, contactRepository.getContact(0)),
        Dept("02-03-2020",100,50, contactRepository.getContact(1))
    )

    override fun getDepts(): List<Dept> {
        return depts
    }

}