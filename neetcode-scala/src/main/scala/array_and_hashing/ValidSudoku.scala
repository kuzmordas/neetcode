package array_and_hashing

// https://leetcode.com/problems/valid-sudoku/submissions/964423659/

object ValidSudoku extends App {

  val board = Array(
    Array('7', '.', '.', '.', '4', '.', '.', '.', '.'),
    Array('.', '.', '.', '8', '6', '5', '.', '.', '.'),
    Array('.', '1', '.', '2', '.', '.', '.', '.', '.'),
    Array('.', '.', '.', '.', '.', '9', '.', '.', '.'),
    Array('.', '.', '.', '.', '5', '.', '5', '.', '.'),
    Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
    Array('.', '.', '.', '.', '.', '.', '2', '.', '.'),
    Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
    Array('.', '.', '.', '.', '.', '.', '.', '.', '.')
  )

  println(isValidSudoku(board))

  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    val corners = Array(
      getRange(board, 0, 2, 0, 2),
      getRange(board, 0, 2, 3, 5),
      getRange(board, 0, 2, 6, 8),
      //
      getRange(board, 3, 5, 0, 2),
      getRange(board, 3, 5, 3, 5),
      getRange(board, 3, 5, 6, 8),
      //
      getRange(board, 6, 8, 0, 2),
      getRange(board, 6, 8, 3, 5),
      getRange(board, 6, 8, 6, 8)
    )

    board.forall(isValid) &&
    board.transpose.forall(isValid) &&
    corners.forall(isValid)
  }

  def getRange(arr: Array[Array[Char]], startRow: Int, endRow: Int, startColumn: Int, endColumn: Int): Array[Char] = {
    val res = scala.collection.mutable.ArrayBuffer[Char]()
    for (i <- startRow to endRow) {
      for (j <- startColumn to endColumn) {
        res += arr(i)(j)
      }
    }

    res.toArray
  }

  def isValid(arr: Array[Char]): Boolean = {
    val set = arr.filter(c => c != '.')
    set.distinct.length == set.length
  }

}
