package nl.pvanassen.euler.scala

import scala.language.implicitConversions

/**
 *
 * @author Paul van Assen
 *
 */
class Euler9 extends EulerSolution {
  val problemNumber = 9

  protected def execute(): String ={
    val lower = (1 to 200).map(i => (i, i*i))
    val upper = (200 to 400).map(j => (j, j*j))
    lower
      .flatMap(i => upper.map(j => (i._1, j._1, j._2 + i._2)))
      .filter(n => Math.sqrt(n._3).isWhole())
      .filter(i => i._1 + i._2 + Math.sqrt(i._3) == 1000)
      .map(i => i._1 * i._2 * i._3)
      .head
      .toString
  }

}
