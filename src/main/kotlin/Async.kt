import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

    // sequential atau berderetan ... (I)
    /*val capital = getCapital()
    val income = getIncome()
    println("Your profit is ${income - capital}")*/

    // pemanfaatan async yang sesungguhnya ... (II)
    /*val capital = async { getCapital() }
    val income = async { getIncome() }
    println("Your profit is ${income.await() - capital.await()}")*/

    // membandingkan waktu approach I dengan approach II
    val timeOne = measureTimeMillis {
        val capital = getCapital()
        val income = getIncome()
        println("Your profit is ${income - capital}")
    } // 2022 ms

    val timeTwo = measureTimeMillis {
        val capital = async { getCapital() }
        val income = async { getIncome() }
        println("Your profit is ${income.await() - capital.await()}")
    } // 1014 ms

    println("Complete in $timeOne ms vs $timeTwo ms") // Complete in 2022 ms vs 1014 ms
}

suspend fun getCapital(): Int {
    delay(1000L)
    return 50000
}

suspend fun getIncome(): Int {
    delay(1000L)
    return 75000
}