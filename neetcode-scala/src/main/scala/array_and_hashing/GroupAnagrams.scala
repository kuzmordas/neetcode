package array_and_hashing

import scala.collection.mutable.ListBuffer

// https://leetcode.com/problems/group-anagrams//

object GroupAnagrams extends App {

  val r = groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat"))
  println(r)

  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs.toList.groupBy(_.sorted).values.toList
  }

  def mutableGroupAnagrams(strs: Array[String]): List[List[String]] = {
    val result = scala.collection.mutable.Map[Int, ListBuffer[ListBuffer[String]]]()

    for (i <- strs.indices) {
      val str = strs(i)
      result.get(str.length) match {
        case Some(l) =>
          l.find(x => isAnagram(x.head, str)) match {
            case Some(value) => value += str
            case None        => l += ListBuffer(str)
          }
        case None =>
          result += (str.length -> ListBuffer(ListBuffer(str)))
      }
    }

    result.flatten(_._2.map(_.toList)).toList
  }

  def immutableGroupAnagrams(strs: Array[String]): List[List[String]] = {
    strs
      .foldLeft(Map[Int, Map[String, List[String]]]())((acc, curr) => {
        acc.get(curr.length) match {
          case Some(map) =>
            map.find(x => isAnagram(x._1, curr)) match {
              case Some((key, strs)) =>
                val nextList = strs :+ curr
                val nextMap  = map + (key -> nextList)
                acc + (curr.length -> nextMap)
              case None =>
                val nextMap = map + (curr -> List(curr))
                acc + (curr.length -> nextMap)
            }
          case None =>
            val nextMap = Map[String, List[String]](curr -> List(curr))
            acc + (curr.length -> nextMap)
        }
      })
      .flatten(x => x._2.values)
      .toList
  }

  def isAnagram(s: String, t: String): Boolean = {
    if (s.length == t.length) {
      return s.sorted == t.sorted
    }

    false
  }

}
