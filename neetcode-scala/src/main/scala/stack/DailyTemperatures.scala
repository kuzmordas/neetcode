package stack

// https://leetcode.com/problems/daily-temperatures/

object DailyTemperatures extends App {

  val result = dailyTemperatures(Array[Int](73, 72, 75, 71, 69, 72, 76, 73))
  println(result.toList)

  def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
    val result = Array.ofDim[Int](temperatures.length)
    val stack  = scala.collection.mutable.Stack[Int](0)

    for (i <- 1 until result.length) {

      while (stack.nonEmpty && temperatures(stack.top) < temperatures(i)) {
        result(stack.top) = i - stack.top
        stack.pop()
      }

      stack.push(i)
    }

    result
  }

  def dailyTemperatures2(temperatures: Array[Int]): Array[Int] = {
    val result = Array.ofDim[Int](temperatures.length)

    for (i <- result.indices) {
      var k = i + 1
      var r = -1

      while (k < result.length && r == -1) {
        if (temperatures(k) > temperatures(i)) {
          r = k - i
          result(i) = r
        } else {
          k += 1
        }
      }
    }

    result
  }

}
