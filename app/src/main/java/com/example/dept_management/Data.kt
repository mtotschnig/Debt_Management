package com.example.dept_management

import java.util.*

data class Contact (
    val name: String,
    val id: Int,
    val budget: Long
        )

data class Dept (
    val opened: String,
    val total: Long,
    val paid: Long,
    val contact: Contact
        )

fun randomDept(): Dept {
    return Dept("01-05-2021", 100,0,Contact("Fabienne",0,1000))
}