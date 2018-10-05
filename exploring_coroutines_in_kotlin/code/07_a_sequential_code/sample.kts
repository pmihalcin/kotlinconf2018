import kotlinx.coroutines.experimental.*

fun getStockPrice(ticker: String): String {   
  return java.net.URL(
    "http://localhost:8085?ticker=$ticker").readText()
}

fun getIPAddress(): String {
  return java.net.URL("https://api.ipify.org").readText()
}                              
         
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
