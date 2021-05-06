package com.example.dept_management

import java.util.*

data class User (
    val name: String,
    val id: UUID = UUID.randomUUID(),
    val budget: Long,
    val depts: List<Dept>? = null
        )

data class Dept (
    val opened: Date,
    val total: Long,
    val paid: Long,
    val contact: User
        )
