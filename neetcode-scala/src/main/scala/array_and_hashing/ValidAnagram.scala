package array_and_hashing

// https://leetcode.com/problems/valid-anagram/

object ValidAnagram extends App {

  println(isAnagram("anagram", "nagaram"))

  def isAnagram(s: String, t: String): Boolean = {
    if (s.length == t.length) {
      return s.sorted == t.sorted
    }

    false
  }

}
