package two_pointers

// https://leetcode.com/problems/trapping-rain-water/
object TrappingRainWater extends App {

//  0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
//  4, 2, 0, 3, 2, 5
//  3, 1, 2
  val arr = Array[Int](3, 1, 2)

  println(trap(arr))

  def trap(height: Array[Int]): Int = {
    val maxLefts  = height.tail.foldLeft(List[Int](height.head))((acc, curr) => acc :+ Math.max(acc.last, curr))
    val maxRights = height.foldRight(List[Int](height.last))((curr, acc) => acc :+ Math.max(acc.last, curr)).reverse
    val boundary  = maxLefts.zip(maxRights).map { case (x, y) => Math.min(x, y) }
    height.zip(boundary).foldLeft(0)((acc, curr) => acc + curr._2 - curr._1)
  }
}
