package com.example.dept_management

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface DebtRepository {
    fun getDebts(): LiveData<List<Debt>>
    fun getDebt(id: Int): Debt?
    fun addDebt(debt: Debt)
    fun removeDebt(debt: Debt)
    fun editDebt(debt: Debt, pos: Int)
    fun getIndex(debt: Debt): Int?
}

class MockDebtRepository : DebtRepository {

    private var debts: MutableLiveData<List<Debt>> = MutableLiveData(listOf(
        Debt("Test")
    ))

    override fun getDebts(): LiveData<List<Debt>> {
        return debts
    }

    override fun getDebt(id: Int): Debt? {
        return if(id != -1) {
            debts.value?.get(id)
        } else {
            null
        }
    }

    override fun getIndex(debt: Debt): Int? {
        return debts.value?.indexOf(debt)
    }

    override fun addDebt(debt: Debt) {
        val newList = debts.value?.plus(debt)
        debts.postValue(newList)
    }

    override fun removeDebt(debt: Debt) {
        val newList : MutableList<Debt> = debts.value as MutableList<Debt>
        newList.remove(debt)
        debts.postValue(newList)
    }

    override fun editDebt(debt: Debt , pos: Int) {
        val currentDebt: Debt = requireNotNull(debts.value?.get(pos))
        require(currentDebt.id == debt.id) {
            "ID Error"
        }
        val newList = debts.value?.toMutableList().also {
            it?.set(pos, debt)
        }
        debts.postValue(newList)
    }

}