package stack

// https://leetcode.com/problems/largest-rectangle-in-histogram/
object LargestRectangleInHistogram extends App {

  val result = largestRectangleArea(Array(2, 1, 5, 6, 2, 3))
  println(result)

  sealed trait Direction
  case object Left  extends Direction
  case object Right extends Direction

  def findLess(i: Int, arr: Array[Int], direction: Direction = Left): Option[Int] = {
    val value = arr(i)
    def recur(i: Int, arr: Array[Int]): Option[Int] = {
      val next = direction match {
        case Left  => i - 1
        case Right => i + 1
      }

      if ((i == 0 && direction == Left) || (i == arr.length - 1 && direction == Right)) None
      else if (arr(next) < value) Some(next)
      else recur(next, arr)
    }

    recur(i, arr)
  }

  def largestRectangleArea(heights: Array[Int]): Int = {
    var result = 0

    for (i <- heights.indices) {
      val h     = heights(i)
      val left  = findLess(i, heights, Left).getOrElse(-1)
      val right = findLess(i, heights, Right).getOrElse(heights.length)

      if (left == right) {
        result = Math.max(h, result)
      } else {
        result = Math.max((right - left - 1) * h, result)
      }
    }

    result
  }

  def naiveLargestRectangleArea(heights: Array[Int]): Int = {
    val uniq   = heights.distinct
    var result = 0

    for (h <- uniq) {
      var q = 0
      var r = 0

      for (i <- heights.indices) {
        if (heights(i) >= h) {
          r += 1
        } else {
          q = if (r > q) r else q
          r = 0
        }
      }

      q = if (r > q) r else q

      val x = q * h
      result = if (x > result) x else result
    }

    result
  }

}
