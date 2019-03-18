package nl.pvanassen.euler.scala

import scala.collection.immutable.Stream.range
import scala.language.implicitConversions

/**
 *
 * @author Paul van Assen
 *
 */
class Euler7 extends EulerSolution {
  val problemNumber = 7

  def stream(i: Long): Stream[Long] = i #:: stream(i + 2)

  protected def execute(): String =
    stream(3)
      .filter(isPrime)
      .take(10000)
      .last
      .toString


  def isPrime(possiblePrime: Long): Boolean =
    range(3L, possiblePrime - 1L, 2L)
      .dropWhile(i => !(possiblePrime % i == 0))
      .isEmpty

}
