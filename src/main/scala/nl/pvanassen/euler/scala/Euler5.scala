package nl.pvanassen.euler.scala
import scala.language.implicitConversions
/**
 *
 * @author Paul van Assen
 *
 */
class Euler5 extends EulerSolution {
  val problemNumber = 5

  def stream(i: Int): Stream[Int] = i #:: stream(i + 20)

  private val div = 2 to 20

  protected def execute(): String =
    stream(20)
      .view
      .filter(divAll)
      .take(1)
      .head
      .toString

  def divAll(i:Int): Boolean =
    div
      .map(n => (i % n != 0).toInt)
      .sum == 0

  implicit def bool2int(b:Boolean):Int = if (b) 1 else 0
}
