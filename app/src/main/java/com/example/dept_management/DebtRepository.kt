package com.example.dept_management

interface DebtRepository {
    fun getDebts(): List<Debt>
    fun getDebt(id: Int): Debt?
}

class MockDebtRepository : DebtRepository {

    private var debts: List<Debt> = listOf(
        Debt("Test",100,0)
    )

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