import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val capital = async { getCapital() } // getCapital() diambil dari file Async.kt
    val income = async { getIncome() } // getIncome() diambil dari file Async.kt
    println("Your profit is ${income.await() - capital.await()}")
}