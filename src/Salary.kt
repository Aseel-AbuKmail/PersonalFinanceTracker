class Salary (var balance: Int){

    fun deposit(amount: Int): Int {
        balance += amount
        println("Your balance after deposit process is $balance")

    }


    fun withdrawal(amount: Int): Int {
        balance -= amount
        println("Your balance after withdraw process is $balance")

    }

    fun GetBalance(balance: Int): Int {
        return balance

    }

}