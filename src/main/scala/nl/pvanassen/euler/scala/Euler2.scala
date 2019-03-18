package nl.pvanassen.euler.scala

/**
 *
 * @author Paul van Assen
 *
 */
class Euler2 extends EulerSolution {
  val fibonacci: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibonacci.zip(fibonacci.tail).map {n => n._1 + n._2}
  val problemNumber = 2

  protected def execute(): String =
    fibonacci
      .takeWhile(_ < 4000000)
      .filter(_ % 2 == 0)
      .sum
      .toString

}
