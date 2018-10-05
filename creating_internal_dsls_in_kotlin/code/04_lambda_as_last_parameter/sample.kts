//fun process(func: (Int) -> Unit, n: Int) {
//  func(n * 2)
//}
//
//process({e -> println(e)}, 2)

fun process(n: Int, func: (Int) -> Unit) {
  func(n * 2)
}

process(2, {e -> println(e)})

process(2) { e -> println(e) }