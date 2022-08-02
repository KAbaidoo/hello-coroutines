import kotlinx.coroutines.*


/*
* - Each coroutine has a CoroutineScope
* - Coroutine context can be inherited from parent to child
* - coroutineContext has two properties: dispatcher and job as well as job
* - dispatcher decides on which thread the coroutine will execute
* */

////Scopes
//fun main() = runBlocking {
//    println("runBlocking: $this") // the scope is accessed using this keyword
//
//    launch {
//        println("launch: $this")
//        launch {
//            println("child launch: $this")
//        }
//    }
//
//    async {
//        println("async: $this")
//    }
//
//    println("...some other code...")
//}


//Context
fun main() = runBlocking {// Thread: main
    // this: CoroutineScope instance
    //  coroutineContext: CoroutineContext instance


    // Without Parameter: CONFINED  [CONFINED DISPATCHER]
    launch {
        println("C1: ${Thread.currentThread().name}")  // Thread main
        delay(1000)
        println("C1: ${Thread.currentThread().name}")  // Thread main
    }


    // With Parameter: Dispatchers.Default  [similar to GlobalScope.launch { }]
    launch (Dispatchers.Default){
        println("C2: ${Thread.currentThread().name}") // separate background thread
        delay(1000)
        println("C2 after delay: ${Thread.currentThread().name}") //  first thread or some other thread
    }


    // With Parameter: Dispatchers.Unconfined  [similar to GlobalScope.launch { }]
    launch (Dispatchers.Unconfined){
        println("C3: ${Thread.currentThread().name}") // Thread: T1
        delay(100)
        println("C3 after delay: ${Thread.currentThread().name}") //   some other thread
    }


    launch (coroutineContext){
        println("C4: ${Thread.currentThread().name}")  // Thread main
        delay(1000)
        println("C4 after delay: ${Thread.currentThread().name}")  // Thread main
    }


    println("...Main program...")
}
