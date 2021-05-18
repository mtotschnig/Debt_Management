package com.example.dept_management

import kotlin.random.Random

data class Contact (
    val name: String,
    val id: Int,
    val budget: Long
        )

data class Debt (
    val name: String,
    val total: Long? = 100,
    var paid: Long? = 0,
    val id : Int = Random.nextInt()
        )

/*
fun randomDept(): Debt {
    return Debt("Max", 100,0,)
}
 */