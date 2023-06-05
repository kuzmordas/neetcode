package array_and_hashing

// https://leetcode.com/problems/longest-consecutive-sequence/

object LongestConsecutive extends App {

  println(longestConsecutive(Array(1, 2, 0, 1)))

  def longestConsecutive(nums: Array[Int]): Int = {
    if (nums.isEmpty) {
      return 0
    }

    val sorted = nums.sorted.distinct

    var r       = 0
    var counter = 1

    for (i <- 1 until sorted.length) {
      if (sorted(i) - sorted(i - 1) == 1) {
        counter += 1
      } else {
        if (counter > r) {
          r = counter
          counter = 1
        } else {
          counter = 1
        }
      }
    }

    if (counter > r) {
      r = counter
    }

    r
  }

}
