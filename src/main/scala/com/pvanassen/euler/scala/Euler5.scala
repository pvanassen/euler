package com.pvanassen.euler.scala
import scala.language.implicitConversions
/**
 *
 * @author Paul van Assen
 *
 */
class Euler5 extends EulerSolution {
  val problemNumber = 5
  implicit def bool2int(b:Boolean):Int = if (b) 1 else 0
  def stream(i: Int): Stream[Int] = i #:: stream(i + 20)
  val div = 2 to 20
  protected def execute(): String ={
    return stream(20).view.filter(divAll(_)).take(1).head.toString
  }

  def divAll(i:Int): Boolean = {
    // return div.takeWhile(n => (i % n != 0)).isEmpty

    return div.map(n => (i % n != 0).toInt).sum == 0
  }
}
