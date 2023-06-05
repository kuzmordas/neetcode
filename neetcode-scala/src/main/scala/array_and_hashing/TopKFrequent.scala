package array_and_hashing

// https://leetcode.com/problems/top-k-frequent-elements/description/

object TopKFrequent extends App {

  val r = topKFrequent(Array(4, 1, -1, 2, -1, 2, 3), 2)
  println(r.toList)

  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {

    val map = nums.foldLeft(Map[Int, Int]())((acc, curr) =>
      acc.get(curr) match {
        case Some(value) => acc + (curr -> (value + 1))
        case None        => acc + (curr -> 1)
      }
    )

    map.toSeq.sortBy(_._2).reverse.take(2).map(_._1).toArray
  }
}
