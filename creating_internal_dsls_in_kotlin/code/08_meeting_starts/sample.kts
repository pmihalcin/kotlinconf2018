class Meeting(val name: String) {
  val starts = this
  
  infix fun at(time: IntRange) {
    println("$name meeting starts at $time")
  }
}
  
infix fun String.meeting(block: Meeting.() -> Unit) {
  Meeting(this).block()
}

"Planning" meeting { 
  starts at 3..15
}