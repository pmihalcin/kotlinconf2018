fun getStockPrice(ticker: String): String {   
  return java.net.URL(
    "http://localhost:8085?ticker=$ticker").readText()
}

fun measureTime(block: () -> Unit) {
  val start = System.nanoTime()
  
  block()
  
  val end = System.nanoTime()
  
  println("${(end - start)/1.0e9} seconds")
}

measureTime {
  val tickers = listOf("GOOG", "AMZN", "MSFT")

  val prices = mutableListOf<String>()

  for(ticker in tickers) {
    prices += "Price for $ticker is $${getStockPrice(ticker)}"
  }                                          

  for(price in prices) {
    println(price)
  }  
}

