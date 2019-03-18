package nl.pvanassen.euler.scala

import scala.language.implicitConversions

/**
 *
 * @author Paul van Assen
 *
 */
class Euler6 extends EulerSolution {
  val problemNumber = 6

  protected def execute(): String ={
    val range = 1 to 100

    ((range.sum * range.sum) - range.map(t => t * t).sum)
      .toString
  }
}
