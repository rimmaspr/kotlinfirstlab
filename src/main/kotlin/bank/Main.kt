package bank

fun main() {
    val bank1 = Bank(1488.08, 420.0, 69.8)
    Thread.sleep(1)
    val bank2 = Bank(1488.00, 420.0, 69.0)

    println(bank1.id)
    println(bank2.id)

    val bank = Bank(100.0, 100.0, 10.0)
    val cashRegister = bank.createCashRegister()

    println("Текущий курс: ${cashRegister.showRate()}")

    bank.updateExchangeRate(99.9)
    println("Обновленный курс: ${cashRegister.showRate()}")
}
