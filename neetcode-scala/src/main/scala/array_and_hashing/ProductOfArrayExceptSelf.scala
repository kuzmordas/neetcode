package array_and_hashing

// https://leetcode.com/problems/product-of-array-except-self/

object ProductOfArrayExceptSelf extends App {

  val r = productExceptSelf(Array(-1, 1, 0, -3, 3))
  println(r.toList)

  def productExceptSelf(nums: Array[Int]): Array[Int] =
    nums.indices
      .map(i => {
        val left  = getProduct(nums, 0, i)
        val right = getProduct(nums, i + 1, nums.length)
        left * right
      })
      .toArray

  def getProduct(nums: Array[Int], startIndex: Int, endIndex: Int, res: Int = 1): Int =
    if (startIndex >= endIndex) {
      res
    } else {
      getProduct(nums, startIndex + 1, endIndex, nums(startIndex) * res)
    }

}
