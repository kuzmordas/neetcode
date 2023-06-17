package two_pointers

// https://leetcode.com/problems/container-with-most-water/

object ContainerWithMostWater extends App {

  println(maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)))

  def maxArea(height: Array[Int]): Int = {
    var result     = 0
    var lowerBound = 0
    var upperBound = height.length - 1

    while (lowerBound < upperBound) {
      val array = Math.min(height(lowerBound), height(upperBound)) * (upperBound - lowerBound)
      if (array > result) {
        result = array
      }

      if (height(lowerBound) < height(upperBound)) {
        lowerBound += 1
      } else {
        upperBound -= 1
      }
    }

    result
  }
}
