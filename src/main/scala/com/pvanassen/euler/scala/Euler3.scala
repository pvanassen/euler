package com.pvanassen.euler.scala

/**
 *
 * @author Paul van Assen
 *
 */
class Euler3 extends EulerSolution {
  val problemNumber = 3
  val num = 600851475143L

  protected def execute(): String ={
    return Stream.range(5L, Math.ceil(Math.sqrt(num)).toLong, 2L).filter(i => num % i == 0).filter(isPrime).takeRight(1).last.toString
  }

  def isPrime(possiblePrime: Long): Boolean = {
    Stream.range(5L, Math.ceil(Math.sqrt(possiblePrime)).toLong, 6L).dropWhile(i => !(possiblePrime % i == 0 || possiblePrime % (i + 2) == 0)).isEmpty
  }
}
