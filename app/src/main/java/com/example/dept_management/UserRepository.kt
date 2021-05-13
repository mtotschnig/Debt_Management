package com.example.dept_management

interface UserRepository {
    fun getContacts(): List<Contact>
    fun getContact(id: Int) : Contact
}

class MockUserRepository : UserRepository{
    override fun getContacts(): List<Contact> {
        return listOf(
            Contact(name = "Fabienne", budget = 5000, id = 0),
            Contact(name = "Till", budget = 2000, id = 1)
            )
    }

    override fun getContact(id: Int) :Contact {
        for (contact in getContacts()) {
            if(contact.id == id)
                return contact
        }
        throw Exception("ERROR NO USER FOUND")
    }
}