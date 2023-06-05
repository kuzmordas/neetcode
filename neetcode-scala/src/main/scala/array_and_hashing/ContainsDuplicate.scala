package array_and_hashing

// https://leetcode.com/problems/contains-duplicate/

object ContainsDuplicate extends App {

  println(containsDuplicate(Array(1, 2, 3, 4)))

  def containsDuplicate(nums: Array[Int]): Boolean = {
    for (i <- nums.indices) {
      for (j <- i + 1 until nums.length) {
        if (nums(i) == nums(j)) {
          return true
        }
      }
    }

    false
  }

  def containsDuplicateRec(nums: Array[Int]): Boolean = {
    def recur1(elementIndex: Int, pointer: Int): Boolean = {
      if (pointer == nums.length) {
        false
      } else {
        if (nums(elementIndex) == nums(pointer)) {
          true
        } else {
          recur1(elementIndex, pointer + 1)
        }

      }
    }

    def recur2(elementIndex: Int = 0, pointer: Int = 1): Boolean = {
      if (pointer == nums.length) {
        false
      } else {
        val r = recur1(elementIndex, pointer)
        if (r) {
          r
        } else {
          recur2(elementIndex + 1, pointer + 1)
        }
      }
    }

    recur2()
  }

}
