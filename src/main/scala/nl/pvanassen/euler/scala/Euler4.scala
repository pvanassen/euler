package nl.pvanassen.euler.scala

/**
 *
 * @author Paul van Assen
 *
 */
class Euler4 extends EulerSolution {
  val problemNumber = 4


  protected def execute(): String =
    (100 to 999)
      .flatMap(n => (n to 999).map(i => i * n).toList)
      .distinct
      .filter(num => num.toString.reverse == num.toString)
      .distinct
      .minBy(-_)
      .toString

}
