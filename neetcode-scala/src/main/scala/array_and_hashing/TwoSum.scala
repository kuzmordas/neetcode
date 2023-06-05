package array_and_hashing

// https://leetcode.com/problems/two-sum/

object TwoSum extends App {

  val r = twoSum(Array(2, 7, 11, 15), 9)
  println(r.mkString(","))

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {

    for (i <- nums.indices) {
      for (j <- i + 1 until nums.length) {
        if (nums(i) + nums(j) == target) {
          return Array(i, j)
        }
      }

    }

    throw new Exception("not found")
  }
}
