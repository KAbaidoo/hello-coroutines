import kotlinx.coroutines.*


fun main() {
    println("Main programs starts: ${Thread.currentThread().name}")

    GlobalScope.launch {
        println("Work starts: ${Thread.currentThread().name}")
        Thread.sleep(1000)      //Pretending to do some work....maybe file upload
        println("Work ends: ${Thread.currentThread().name}")
    }
    runBlocking { // Creates a couroutine that blocks the current main thread
        delay(2000) // wait for coroutine to fish (ppractically not a right way to wait
    }

    println("Main programs ends: ${Thread.currentThread().name}")
}