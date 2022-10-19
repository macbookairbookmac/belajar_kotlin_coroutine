import kotlinx.coroutines.*

// menggunakan launch
fun main() = runBlocking {
    val job = launch(start = CoroutineStart.LAZY){ // fungsi CoroutineStart.LAZY adalah ...
        // ... membuat job tanpa langsung menjalankannya.
        // Do background task here
        delay(1000L)
        println("Start new job!")
    }

    //job.start() // menggunakan start -> memulai job tanpa harus menunggu job tersebut selesai
    /*
    Other task
    Start new job!
     */

    job.join() // menggunakan join -> menunda eksekusi sampai job selesai.
    println("Other task")
    /*
    Start new job!
    Other task
     */

}

// menggunakan Job
fun main2() = runBlocking {
    val job = Job()
}