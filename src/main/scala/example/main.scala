package parsers


object Main {
  def main(args: Array[String]) = {
    val result = RpnParser.evaluate(args)
    println(result)
  }
}