import kotlinx.coroutines.experimental.*

suspend fun getStockPrice(ticker: String): String {   
  return java.net.URL(
    "http://localhost:8085?ticker=$ticker").readText()
}

suspend fun getIPAddress(): String {
  return java.net.URL("https://api.ipify.org").readText()
}                              
         
val latch = java.util.concurrent.CountDownLatch(1)

launch {
  val ticker = "GOOG"

  try {                                                
    val price = getStockPrice(ticker)

    try {
      val ip = getIPAddress()

      println("Price for $ticker is $price, requested from $ip.await")
    } catch(ex: Exception) {
      println("Unable to get ip address")
    }
  } catch(ex: Exception) {
    println("Error getting price for $ticker")
  }
  
  latch.countDown()
}

latch.await()