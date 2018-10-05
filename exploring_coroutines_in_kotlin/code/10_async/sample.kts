import kotlinx.coroutines.experimental.*

fun getStockPrice(ticker: String): String {   
  return java.net.URL(
    "http://localhost:8085?ticker=$ticker").readText()
}

suspend fun measureTime(block: suspend () -> Unit) {
  val start = System.nanoTime()
  
  block()
  
  val end = System.nanoTime()
  
  println("${(end - start)/1.0e9} seconds")
}
             
launch {
  measureTime {
    val tickers = listOf("GOOG", "AMZN", "MSFT")

    val prices = mutableListOf<Deferred<String>>()

    for(ticker in tickers) {
      prices += async { "Price for $ticker is $${getStockPrice(ticker)}" }
    }                                          

    for(price in prices) {
      println(price.await())
    }  
  }  
}

Thread.sleep(5000)
