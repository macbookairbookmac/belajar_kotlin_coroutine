import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// menjalankannya agar tampak perbedaan sending antar coroutine adalah ...
// ... dengan menambahkan -Dkotlinx.coroutines.debug pada VM Options di file yang ingin dijalankan
// maka akan tampak perbedaan dari coroutine yang mengirim dan menerima

fun main() = runBlocking(CoroutineName("main")) {
    val channel = Channel<Int>()
    launch(CoroutineName("vIcoroutine")){
        println("Sending from ${Thread.currentThread().name}")
        for (x in 1..5) channel.send(x * x)
    }

    repeat(5){
        println(channel.receive())
    }
    println("received in ${Thread.currentThread().name}")
}