package com.example.dept_management

interface DeptRepository {
    fun getDepts(): List<Debt>
}

class MockDeptRepository : DeptRepository {

    var contactRepository: MockUserRepository = MockUserRepository()
    private var debts: List<Debt> = listOf(
        Debt("01-03-2021",1000,0, contactRepository.getContact(0)),
        Debt("02-03-2020",100,50, contactRepository.getContact(1))
    )

    override fun getDepts(): List<Debt> {
        return debts
    }

}