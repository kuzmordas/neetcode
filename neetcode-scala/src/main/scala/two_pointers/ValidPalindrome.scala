package two_pointers

// https://leetcode.com/problems/valid-palindrome/

object ValidPalindrome extends App {

  println(isPalindrome("A man, a plan, a canal: Panama")) // => true
  println(isPalindrome(" "))                              // => true
  println(isPalindrome("race a car"))                     // => false

  def isPalindrome(s: String): Boolean = {
    val alphabeticNumeric = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase()

    for (i <- alphabeticNumeric.indices) {
      if (alphabeticNumeric(i) != alphabeticNumeric(alphabeticNumeric.length - 1 - i)) return false
    }

    true
  }
}
