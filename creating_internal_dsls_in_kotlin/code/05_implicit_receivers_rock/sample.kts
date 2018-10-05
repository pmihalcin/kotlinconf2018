fun call(greet: String.(name: String) -> Unit) {
  //greet("Hello", "Jane")
  
  "Hello".greet("Jane")
}

call { name ->
  println("$this $name")
}