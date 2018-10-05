fun process(n: Int): Int {
  println("process: ${Thread.currentThread()}")
  return n * 2;
}
                 
println(Thread.currentThread())
println(process(2))