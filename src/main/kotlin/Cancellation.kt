import kotlinx.coroutines.*

/*
* Reasons why you might cancel a coroutine are
* - You no longer need the results
* - Coroutine is taking too long to respond
*
* To cancel a coroutine, it has to be cooperative
* What makes a coroutine cooperative?
* ====================================
* Two ways to make a coroutine cooperative
* 1. Periodically invoke a suspending function that checks for cancellation.
* - Only those suspending functions that belongs to kotlinx,coroutines package
*    will make coroutine cooperative
* - delay(), yield(), withContext(), withTimeout() etc.
* are the suspending functins that belongs to kotlinx.coroutines package
*2. Explicitly check for the cancellation status within the coroutine
* - CoroutineScope.isActive boolean flag
*
*
*   */

//fun main()= runBlocking {
//    println("Main program starts; ${Thread.currentThread().name}")  //Main thread
//
//    val job: Job = launch (Dispatchers.Default){// not cancellable
//        for (i in 0..500){
//            if(!isActive){
//               // break
//                return@launch // returns to the coroutine level
//            }
//            print("$i.")
//            Thread.sleep(1)
//           // yield() //delay(50)
//        }
//    }
//    delay(10)
//    job.cancelAndJoin()
//
//    println("\nMain program ends: ${Thread.currentThread().name}")
//
//}

/*  Handling Exceptions
==================================================
    Cancellable suspend function
* */

//
//fun main()= runBlocking {
//    println("Main program starts; ${Thread.currentThread().name}")  //Main thread
//
//    val job: Job = launch (Dispatchers.Default){// not cancellable
//        try {
//            for (i in 0..500){
//                print("$i.")
//                delay(5)
//
//            }
//        } catch (ex: CancellationException){
//            println("\nException caught safely: ${ex.message}")
//        } finally {
//           // delay(1000) // Generally we don't use suspending function in finally
//            withContext(NonCancellable){
//                delay(1000)
//            }
//
//            println("Close resources in finally")
//        }
//    }
//    delay(10)
//   job.cancel(CancellationException("my own crash message"))
//    job.join()
//
//    println("\nMain program ends: ${Thread.currentThread().name}")
//
//}

/*
*   Timeouts
* ================================
* */

//
//fun main()= runBlocking {
//    println("Main program starts; ${Thread.currentThread().name}")  //Main thread
//
//    withTimeout(2000){// Throws a cancellation exception if the coroutine is not finished
//
//        try {
//            for (i in 0..500){
//                print("$i.")
//                delay(500)
//            }
//        }catch (ex: TimeoutCancellationException) {
//            //..code..
//        }finally {
//            //..code..
//        }
//    }
//
//
//    println("\nMain program ends: ${Thread.currentThread().name}")
//
//}


fun main()= runBlocking {
    println("Main program starts; ${Thread.currentThread().name}")  //Main thread

   val result: String? =  withTimeoutOrNull(2000){// Doesn't throw an exception and no tryCatch block is required

            for (i in 0..500){
                print("$i.")
                delay(500)
            }
       "I am done"// withTimeoutOrNull returns a lambda value or null if timeout

    }
    print("Result: $result")


    println("\nMain program ends: ${Thread.currentThread().name}")

}