package stack

import stack.GenerateParentheses.Node

// https://leetcode.com/problems/generate-parentheses/

object GenerateParentheses extends App {

  println(generateParenthesis(8))

//  ((()))
//  (()())
//  ()(())
//  ()()()

//  "((()))","(()())","(())()","()(())","()()()"

//  val r = scala.collection.mutable.ListBuffer[String]()
//  dfs(3, 0, "", r)
//  println(r.toList)

  case class Node(value: String, left: Int, right: Int, var visited: Boolean = false)

  def generateParenthesis(n: Int): List[String] = {
    val result = scala.collection.mutable.ListBuffer[String]()
    val stack  = scala.collection.mutable.Stack[Node]()
    stack.push(Node("(", n - 1, 1))

    while (stack.nonEmpty) {
      if (stack.top.visited) {
        stack.pop()
      } else {
        stack.top.visited = true

        val right = stack.top.right
        val left  = stack.top.left
        val value = stack.top.value

        if (right > 0) {
          val v = value + ")"
          stack.push(Node(v, left, right - 1))
        }

        if (left > 0) {
          val v = value + "("
          stack.push(Node(v, left - 1, right + 1))
        }

        if (left == 0 && right == 0) {
          result.addOne(stack.top.value)
        }
      }
    }

    result.result()
  }

  def dfs(left: Int, right: Int, res: String, lst: scala.collection.mutable.ListBuffer[String]): Unit = {
    if (left == 0 && right == 0) {
      lst.addOne(res)
      return
    }
    if (left > 0) dfs(left - 1, right + 1, res + "(", lst)
    if (right > 0) dfs(left, right - 1, res + ")", lst)
  }
}
