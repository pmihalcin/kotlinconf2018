import kotlinx.coroutines.experimental.*

fun process(n: Int): Int {
  println("process: ${Thread.currentThread()}")
  return n * 2;
}
                 
println(Thread.currentThread())

val latch = java.util.concurrent.CountDownLatch(1)

launch {
  val result1 = process(1)
  val result2 = process(2)
                                 
  println(result1 + result2)
  latch.countDown()
}

latch.await()
