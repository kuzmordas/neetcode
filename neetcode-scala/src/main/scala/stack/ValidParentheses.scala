package stack

import scala.collection.mutable

// https://leetcode.com/problems/valid-parentheses/

object ValidParentheses extends App {

  println(isValid(")"))

  def isValid(s: String): Boolean = {
    val stack = mutable.Stack[Char]()

    s.toList.foreach {
      case c if c == '(' || c == '[' || c == '{' => stack.push(c)
      case c @ ')'                               => if (stack.nonEmpty && stack.head == '(') stack.pop() else stack.push(c)
      case c @ '}'                               => if (stack.nonEmpty && stack.head == '{') stack.pop() else stack.push(c)
      case c @ ']'                               => if (stack.nonEmpty && stack.head == '[') stack.pop() else stack.push(c)
    }

    stack.isEmpty
  }
}
