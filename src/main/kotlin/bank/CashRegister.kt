package bank

class CashRegister(private val bank: Bank) : CashRegisterInterface {

    override fun exchangeRubToUsd(amount: Double): Double {
        val usdAmount = amount / bank.getExchangeRate()
        val exchangedRub = bank.sendRub(amount)
        if (exchangedRub > 0) {
            bank.receiveUsd(usdAmount)
            println("Касса обменяла $amount рублей на $usdAmount долларов")
            return usdAmount
        }
        return 0.0
    }

    override fun exchangeUsdToRub(amount: Double): Double {
        val rubAmount = amount * bank.getExchangeRate()
        val exchangedUsd = bank.sendUsd(amount)
        if (exchangedUsd > 0) {
            bank.receiveRub(rubAmount)
            println("Касса обменяла $amount долларов на $rubAmount рублей")
            return rubAmount
        }
        return 0.0
    }

    fun showRate(): Double {
        return bank.getExchangeRate()
    }
}
