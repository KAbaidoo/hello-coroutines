import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


// By default functions are executed sequentially
//fun main() = runBlocking {
//    println("Main program starts: ${Thread.currentThread().name}")
//
//    val time = measureTimeMillis {
//        val msgOne = getMessageOne()
//        val msgTwo = getMessageTwo()
//        println("The entire message is: ${msgOne + msgTwo}")
//    }
//    println("Completed in $time ms")
//    println("Main program ends: ${Thread.currentThread().name}")
//
//}
//
//suspend fun getMessageOne(): String {
//    delay(1000L) // pretend to do some work
//    return "Hello"
//}
//
//suspend fun getMessageTwo(): String {
//    delay(1000L) // pretend to do some work
//    return " World"
//}


//making them concurrent
//fun main() = runBlocking {
//    println("Main program starts: ${Thread.currentThread().name}")
//
//    val time = measureTimeMillis {
//         val msgOn: Deferred<String> = async {  getMessageOne()}
//        val msgTwo: Deferred<String> = async {  getMessageTwo()}
//        println("The entire message is: ${msgOne.await() + msgTwo.await()}")
//    }
//    println("Completed in $time ms")
//    println("Main program ends: ${Thread.currentThread().name}")
//
//}
//
//suspend fun getMessageOne(): String {
//    delay(1000L) // pretend to do some work
//    return "Hello"
//}
//
//suspend fun getMessageTwo(): String {
//    delay(1000L) // pretend to do some work
//    return " World"
//}


//Lazy
/*
* you can run a coroutine only if the output will be used*/
fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")


        val msgOn: Deferred<String> = async (start = CoroutineStart.LAZY) {  getMessageOne()}
        val msgTwo: Deferred<String> = async (start = CoroutineStart.LAZY){  getMessageTwo()}
//        println("The entire message is: ${msgOne.await() + msgTwo.await()}") // we are not using the return results


    println("Main program ends: ${Thread.currentThread().name}")

}

suspend fun getMessageOne(): String {
    delay(1000L) // pretend to do some work
    println("After working in getMessageOne()")
    return "Hello"
}

suspend fun getMessageTwo(): String {
    println("After working in getMessageTwo()")
    delay(1000L) // pretend to do some work
    return " World"
}