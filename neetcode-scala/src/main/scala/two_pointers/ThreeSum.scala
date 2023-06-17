package two_pointers

// https://leetcode.com/problems/3sum/

object ThreeSum extends App {

  val arr = Array[Int](0, 0, 0)
  val r   = threeSum(arr)
  println(r)

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val sorted = nums.sorted

    val res = scala.collection.mutable.ListBuffer[List[Int]]()

    for (i <- 0 until sorted.length - 2) {
      var j = i + 1
      var k = sorted.length - 1

      while (j < k) {
        val sum = sorted(i) + sorted(j) + sorted(k)
        if (sum == 0) {
          res += List(sorted(i), sorted(j), sorted(k))
          j += 1
          k -= 1
        } else if (sum < 0) {
          j += 1
        } else {
          k -= 1
        }
      }
    }

    res.toList.distinct
  }
}
