package parsers

import scala.collection.mutable.Stack
import scala.collection.immutable.HashMap


object RpnParser {
  def evaluate(args: Array[String]) = {
    val sum = (x: Int, y: Int) => x + y
    val sub = (x: Int, y: Int) => x - y
    val mul = (x: Int, y: Int) => x * y
    val div = (x: Int, y: Int) => x / y


    val expressions = HashMap(
      "+" -> sum,
      "-" -> sub,
      "*" -> mul,
      "/" -> div
    )
    
    
    try {
      if(args.isEmpty) throw new ArrayIndexOutOfBoundsException

      var s = Stack[Int]()

      for (n <- args) {
        if(expressions.contains(n)) {
          s.push(expressions(n)(s.pop, s.pop))
          
        } else {
          s.push(n.toInt)
        }
      }

      val finalResult = s.pop

      if(!s.isEmpty) {
        throw new NoSuchElementException
      }

      finalResult

  } catch {
      case e: ArrayIndexOutOfBoundsException => println("No input RPN expression provided")
      case e: NoSuchElementException => println("Invalid RPN expression provided")
      case e: NumberFormatException => println("Invalid RPN expression provided")
    }
  }
}