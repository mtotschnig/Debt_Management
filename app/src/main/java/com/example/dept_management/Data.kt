package com.example.dept_management

data class Contact (
    val name: String,
    val id: Int,
    val budget: Long
        )

data class Debt (
    val opened: String,
    val total: Long,
    val paid: Long,
    val contact: Contact
        )

fun randomDept(): Debt {
    return Debt("01-05-2021", 100,0,Contact("Fabienne",0,1000))
}