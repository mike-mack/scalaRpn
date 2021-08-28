package parsers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RpnParserSpec extends AnyFlatSpec with Matchers {
  "The RpnParser object" should "evaluate RPN expressions correctly" in {
    // Hello.greeting shouldEqual "hello"
    val args = Array("1", "2", "+")
    RpnParser.evaluate(args) shouldEqual 3
  }

  "The RpnParser object" should "evaluate multiplication expressions correctly" in {
    val argsOne = Array("10", "10", "*")
    RpnParser.evaluate(argsOne) shouldEqual 100
    val argsTwo = Array("50", "3", "*")
    RpnParser.evaluate(argsTwo) shouldEqual 150
  }
}
