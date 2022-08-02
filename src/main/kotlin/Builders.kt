import kotlinx.coroutines.*

/*
    * Builders are functions used for creating coroutines
    * There are three most important builders
    *   - launch : GlobalScope.launch Creates coroutine at global (app) level
    *              while launch creates coroutine at local scope
    *   - async : GlobalScope.async Creates coroutine at global (app) level
    *              while async creates coroutine at local scope
    *   - runBlocking : This is mainly used in tests or for blocking main thread
    *  */
// 'launch'
//    fun main() = runBlocking {// Creates c blocking coroutine that executes in the current thread (main)
//        println("Main programs starts: ${Thread.currentThread().name}")
//
//        val job: Job = launch {
//            println("Work starts: ${Thread.currentThread().name}")
//            delay(1000)      //Pretending to do some work....maybe file upload
//            println("Work ends: ${Thread.currentThread().name}")
//        }
//            //job.cancel
//            job.join()
//
//
//        println("Main programs ends: ${Thread.currentThread().name}")
//    }


//'Async'
    fun main() = runBlocking {// Creates c blocking coroutine that executes in the current thread (main)
        println("Main programs starts: ${Thread.currentThread().name}")

        val jobDeffered: Deferred <Int> = async {
            println("Work starts: ${Thread.currentThread().name}")
            delay(1000)      //Pretending to do some work....maybe file upload
            println("Work ends: ${Thread.currentThread().name}")

            15
        }
            //job.cancel
//        jobDeffered.join()
    val num : Int = jobDeffered.await()


        println("Main programs ends: ${Thread.currentThread().name}")
    }


// runBlocking
suspend fun myOwnSuspendingFunc(){
    delay(1000) // do something .......
}