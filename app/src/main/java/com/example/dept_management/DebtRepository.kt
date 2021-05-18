package com.example.dept_management

interface DebtRepository {
    fun getDebts(): List<Debt>
    fun getDebt(id: Int): Debt?
}

class MockDebtRepository : DebtRepository {

    private var debts: List<Debt> = listOf()

    override fun getDebts(): List<Debt> {
        return debts
    }

    override fun getDebt(id: Int): Debt? {
        for (debt in debts) {
            if(debt.id == id)
                return debt
        }
        return null
    }

}