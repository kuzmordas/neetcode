package stack

// https://leetcode.com/problems/min-stack/

object MinStack extends App {

  val minStack = new MinStack();
  minStack.push(-2);
  minStack.push(0);
  minStack.push(-3);
  println(minStack.getMin()) // return -3
  minStack.pop();
  println(minStack.top())     // return 0
  println(minStack.getMin()); // return -2

  class MinStack() {

    private val stack = scala.collection.mutable.ListBuffer[Int]()
    private val min   = scala.collection.mutable.ListBuffer[Int]()

    def push(`val`: Int): Unit = {
      stack += `val`
      min += (if (min.isEmpty) `val` else Math.min(min.last, `val`))
    }

    def pop(): Unit = {
      min.remove(min.length - 1)
      stack.remove(stack.length - 1)
    }

    def top(): Int = stack.last

    def getMin(): Int = min.last

  }

}
