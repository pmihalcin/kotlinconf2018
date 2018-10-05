import java.time.*      

val ago = "ago"
val from_now = "from now"

infix fun Int.days(tense: String) {
  when(tense) {
    ago -> println(LocalDateTime.now().minusDays(this.toLong()))
    from_now -> println(LocalDateTime.now().plusDays(this.toLong()))
    else -> println("")
  }
}


2 days ago
2 days from_now