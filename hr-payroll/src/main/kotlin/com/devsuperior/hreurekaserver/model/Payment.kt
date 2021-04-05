package com.devsuperior.hreurekaserver.model

data class Payment(val name: String, val dailyIncome: Double, val days: Int) {

    fun getTotal(): Double {
        return dailyIncome.times(days)
    }

}