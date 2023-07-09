package stack

// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

object EvaluateReversePolishNotation extends App {

  println(evalRPN(Array("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))

  def evalRPN(tokens: Array[String]): Int = {
    val stack = scala.collection.mutable.Stack[String]()

    tokens.foreach {
      case op @ ("+" | "-" | "*" | "/") =>
        val n1 = stack.pop().toInt
        val n2 = stack.pop().toInt
        op match {
          case "+" => stack.push((n1 + n2).toString)
          case "-" => stack.push((n2 - n1).toString)
          case "*" => stack.push((n1 * n2).toString)
          case "/" => stack.push((n2 / n1).toString)
        }
      case t => stack.push(t)
    }

    stack.pop().toInt
  }

}
