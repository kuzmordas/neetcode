package two_pointers

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

object TwoSumII_InputArrayIsSorted extends App {

  val arr = Array(-1, 0)
  val r   = twoSum(arr, -1)

  println(r.toList)

  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    if (numbers.length == 2) {
      Array[Int](1, 2)
    } else {
      var lowerBound = 0
      var upperBound = numbers.length - 1

      while (lowerBound < upperBound) {
        val sum = numbers(lowerBound) + numbers(upperBound)
        if (sum == target) {
          return Array(lowerBound + 1, upperBound + 1)
        } else if (sum < target) {
          lowerBound += 1
        } else {
          upperBound -= 1
        }
      }

      throw new Exception("Solution must be found")
    }
  }

}
