import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {// (2) launch bekerja
        delay(1000L)
        println("Coroutines!")
    }
    print("Hello, ") // (1) setelah ini langsung ke launch
    delay(2000L) // (3) delay bekerja
}