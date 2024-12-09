package bank

class Bank(
    private var rubBalance: Double,
    private var usdBalance: Double,
    private val exchangeRate: Double = 70.0
) : BankInterface {

    override fun sendRub(amount: Double): Double {
        return if (rubBalance >= amount) {
            rubBalance -= amount
            println("Банк отправил $amount рублей")
            amount
        } else {
            println("Недостаточно рублей в банке для отправки $amount")
            0.0
        }
    }

    override fun sendUsd(amount: Double): Double {
        return if (usdBalance >= amount) {
            usdBalance -= amount
            println("Банк отправил $amount долларов")
            amount
        } else {
            println("Недостаточно долларов в банке для отправки $amount")
            0.0
        }
    }

    override fun receiveRub(amount: Double) {
        rubBalance += amount
        println("Банк получил $amount рублей")
    }

    override fun receiveUsd(amount: Double) {
        usdBalance += amount
        println("Банк получил $amount долларов")
    }

    override fun createCashRegister(): CashRegister {
        return CashRegister(this)
    }

    fun getRubBalance() = rubBalance
    fun getUsdBalance() = usdBalance
    fun getExchangeRate() = exchangeRate
}
