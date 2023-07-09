package stack

// https://leetcode.com/problems/car-fleet/
object CarFleet extends App {

  val result = carFleet(12, Array(10, 8, 0, 5, 3), Array(2, 4, 1, 1, 3))
  println(result)

  def carFleet(target: Int, position: Array[Int], speed: Array[Int]): Int =
    position
      .zip(speed)
      .map {
        case (p, s) => (p, (target - p) / s.toDouble)
      }
      .sortWith(_._1 > _._1)
      .foldLeft(0, 0.0)((acc, curr) => {
        if (acc._2 < curr._2)
          (acc._1 + 1, curr._2)
        else
          acc
      })
      ._1

}
