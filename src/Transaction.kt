data class Transaction(
    val amount: Double,
    val category: String,
    val date: String,
    val transactionType: String // 'income' or 'expense'
)

class TransactionManager {
    private val transactions = mutableListOf<Transaction>()

    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun viewIncomeTransactions(): List<Transaction> {
        return transactions.filter { it.transactionType == "income" }
    }

    fun editTransaction(index: Int, newAmount: Double?, newCategory: String?, newDate: String?, newType: String?) {
        if (index in transactions.indices) {
            val transaction = transactions[index]
            val updatedTransaction = transaction.copy(
                amount = newAmount ?: transaction.amount,
                category = newCategory ?: transaction.category,
                date = newDate ?: transaction.date,
                transactionType = newType ?: transaction.transactionType
            )
            transactions[index] = updatedTransaction
        } else {
            println("Transaction not found.")
        }
    }

    fun deleteTransaction(index: Int) {
        if (index in transactions.indices) {
            transactions.removeAt(index)
        } else {
            println("Transaction not found.")
        }
    }
}
