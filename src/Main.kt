fun main() {
    val manager = TransactionManager()

    // Sample transactions
    manager.addTransaction(Transaction(1000.0, "Salary", "2025-04-01", "income"))
    manager.addTransaction(Transaction(200.0, "Freelance", "2025-04-05", "income"))
    manager.addTransaction(Transaction(500.0, "Rent", "2025-04-06", "expense"))

    mainMenu(manager)
}

fun mainMenu(manager: TransactionManager) {
    while (true) {
        println("\nMain Menu:")
        println("1. View Income Transactions")
        println("2. Edit Transaction")
        println("3. Delete Transaction")
        println("4. Exit")

        print("Choose an option: ")
        when (readLine()) {
            "1" -> viewIncomeTransactions(manager)
            "2" -> editTransaction(manager)
            "3" -> deleteTransaction(manager)
            "4" -> {
                println("Exiting...")
                return
            }
            else -> println("Invalid option. Try again.")
        }
    }
}

fun viewIncomeTransactions(manager: TransactionManager) {
    val incomeTransactions = manager.viewIncomeTransactions()
    if (incomeTransactions.isEmpty()) {
        println("No income transactions available.")
    } else {
        println("Income Transactions:")
        incomeTransactions.forEach { transaction ->
            println("Amount: ${transaction.amount}, Category: ${transaction.category}, Date: ${transaction.date}")
        }
    }
}

fun editTransaction(manager: TransactionManager) {
    print("Enter transaction index to edit: ")
    val index = readLine()?.toIntOrNull() ?: return println("Invalid index.")

    print("Enter new amount: ")
    val newAmount = readLine()?.toDoubleOrNull()

    print("Enter new category: ")
    val newCategory = readLine()

    print("Enter new date (yyyy-mm-dd): ")
    val newDate = readLine()

    print("Enter new transaction type (income/expense): ")
    val newType = readLine()

    manager.editTransaction(index, newAmount, newCategory, newDate, newType)
}

fun deleteTransaction(manager: TransactionManager) {
    print("Enter transaction index to delete: ")
    val index = readLine()?.toIntOrNull() ?: return println("Invalid index.")
    manager.deleteTransaction(index)
}
