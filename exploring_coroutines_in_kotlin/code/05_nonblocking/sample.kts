import kotlinx.coroutines.experimental.*

suspend fun process(n: Int): Int {
  println("process: ${Thread.currentThread()}")
  return n * 2;
}
                 
println(Thread.currentThread())

val latch = java.util.concurrent.CountDownLatch(1)

launch {
  val result1 = async { process(1) }
  val result2 = async { process(2) }
                                 
  println(result1.await() + result2.await())
  latch.countDown()
}

latch.await()