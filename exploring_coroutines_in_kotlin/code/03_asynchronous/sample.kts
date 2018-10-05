import kotlinx.coroutines.experimental.*

fun process(n: Int): Int {
  println("process: ${Thread.currentThread()}")
  return n * 2;
}
                 
println(Thread.currentThread())

val latch = java.util.concurrent.CountDownLatch(1)

launch {
  println(process(2))
  latch.countDown()
}

latch.await()