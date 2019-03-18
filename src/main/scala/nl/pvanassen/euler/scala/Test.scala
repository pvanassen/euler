package nl.pvanassen.euler.scala

import scala.collection.immutable.Stream.range

/**
  * Created by paul on 25-12-2015.
  */
object Test {
  def main(args: Array[String]) {
    (1151 to 100000).filter(isPrime(_)).take(500).foreach(println)
    /*(10101 to 90909).filter(n => {
      val s = n.toString
      s.charAt(1) == '0' && s.charAt(3) == '0' && (s.endsWith("1") || s.endsWith("2"))
    }).filter(isPrime(_)).foreach(println)*/
  }
  def isPrime(possiblePrime: Long): Boolean = {
    range(3L, possiblePrime - 1L, 2L).dropWhile(i => !(possiblePrime % i == 0)).isEmpty
  }
}
