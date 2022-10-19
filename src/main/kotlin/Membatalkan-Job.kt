import kotlinx.coroutines.*

@InternalCoroutinesApi
fun main() = runBlocking {
    val job = launch {
        delay(5000L)
        println("Start new job!")
    }

    delay(2000L)
    //job.cancel() // cancel biasa
    job.cancel(cause = CancellationException("Time is up!")) // cancel dengan exception
    println("Cancelling job...")


    if(job.isCancelled){
        //println("Job is cancelled") // keterangan biasa
        println("Job is cancelled because ${job.getCancellationException().message}") // mengambil nilai cancel exception
    }
}

// nb : jika job yang belum dijalankan memanggil property cancle(),
// maka tidak ada cancelling... melainkan langsung cancelled