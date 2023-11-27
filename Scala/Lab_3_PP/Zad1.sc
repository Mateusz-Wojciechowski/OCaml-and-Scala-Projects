import java.time.LocalDateTime

def Log(prefix: String)(datetime: LocalDateTime)(text: String): Unit = {
  println(s"[${prefix}] ${datetime.toString} \t ${text}")
}

val warn_log = Log("Warn")_
val nightly_warn_log = warn_log(LocalDateTime.now())
nightly_warn_log("Hello")
