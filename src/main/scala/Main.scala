package test

import scala.collection.mutable

object Main {

  def test(in: Int): Unit = {
    var foo = "abcdef"

    val keys = mutable.ListBuffer[Int](1, 2, 3)

    for (k <- keys)
      keys -= k
  }

}
