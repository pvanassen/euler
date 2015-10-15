package com.pvanassen.euler.scala

/**
 *
 * @author Paul van Assen
 *
 */
class Euler1 extends EulerSolution {
  val problemNumber = 1

  protected def execute(): String ={
    return (1 to 1000).filter(n => n % 3 == 0 || n % 5 == 0).sum.toString
  }
}
